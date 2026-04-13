package com.example.progressbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class CircularActivity extends AppCompatActivity {

    ProgressBar circularBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circular);

        circularBar = findViewById(R.id.circularBar);

        circularBar.setVisibility(View.VISIBLE);

        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            runOnUiThread(() -> {
                circularBar.setVisibility(View.GONE);
            });

        }).start();
    }
}
