package com.example.progressbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ProgressBar horizontalBar;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        horizontalBar = findViewById(R.id.horizontalBar);
        btnNext = findViewById(R.id.btnNext);

        // Progress Animation
        new Thread(() -> {
            for (int i = 0; i <= 100; i++) {
                int progress = i;
                runOnUiThread(() -> horizontalBar.setProgress(progress));

                try { Thread.sleep(50); }
                catch (Exception e) { e.printStackTrace(); }
            }
        }).start();

        // Go to Circular Screen
        btnNext.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, CircularActivity.class));
        });
    }
}
