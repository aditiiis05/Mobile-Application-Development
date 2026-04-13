package com.example.progressbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ProgressBar horizontalBar;
    Button btnNext;

    int progress = 0;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        horizontalBar = findViewById(R.id.horizontalBar);
        btnNext = findViewById(R.id.btnNext);

        startProgress();

        btnNext.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CircularActivity.class);
            startActivity(intent);
        });
    }

    private void startProgress() {
        progress = 0;

        new Thread(() -> {
            while (progress <= 100) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                handler.post(() -> horizontalBar.setProgress(progress));
                progress++;
            }
        }).start();
    }
}
