package com.example.alarmapp;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView tvClock;
    Button btnDate, btnTime, btnSetAlarm;

    Calendar alarmCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvClock = findViewById(R.id.tvClock);
        btnDate = findViewById(R.id.btnDate);
        btnTime = findViewById(R.id.btnTime);
        btnSetAlarm = findViewById(R.id.btnSetAlarm);

        startClock();

        btnDate.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();

            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    this,
                    (view, year, month, dayOfMonth) -> {
                        alarmCalendar.set(Calendar.YEAR, year);
                        alarmCalendar.set(Calendar.MONTH, month);
                        alarmCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        Toast.makeText(this, "Date Selected", Toast.LENGTH_SHORT).show();
                    },
                    c.get(Calendar.YEAR),
                    c.get(Calendar.MONTH),
                    c.get(Calendar.DAY_OF_MONTH)
            );

            datePickerDialog.show();
        });

        btnTime.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();

            TimePickerDialog timePickerDialog = new TimePickerDialog(
                    this,
                    (view, hourOfDay, minute) -> {
                        alarmCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        alarmCalendar.set(Calendar.MINUTE, minute);
                        alarmCalendar.set(Calendar.SECOND, 0);

                        Toast.makeText(this, "Time Selected", Toast.LENGTH_SHORT).show();
                    },
                    c.get(Calendar.HOUR_OF_DAY),
                    c.get(Calendar.MINUTE),
                    true
            );

            timePickerDialog.show();
        });

        btnSetAlarm.setOnClickListener(v -> setAlarm());
    }

    private void setAlarm() {

        Intent intent = new Intent(this, AlarmReceiver.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this,
                0,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
        );

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        if (alarmManager != null) {
            alarmManager.setExact(
                    AlarmManager.RTC_WAKEUP,
                    alarmCalendar.getTimeInMillis(),
                    pendingIntent
            );

            Toast.makeText(this, "Alarm Set Successfully 🔔", Toast.LENGTH_SHORT).show();
        }
    }

    private void startClock() {

        Handler handler = new Handler();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                Calendar c = Calendar.getInstance();

                String time = String.format(Locale.getDefault(),
                        "%02d:%02d:%02d",
                        c.get(Calendar.HOUR_OF_DAY),
                        c.get(Calendar.MINUTE),
                        c.get(Calendar.SECOND));

                tvClock.setText(time);

                handler.postDelayed(this, 1000);
            }
        };

        handler.post(runnable);
    }
}
