package com.example.progressbar;

import android.os.Bundle;
import android.os.Handler;
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

        new Handler().postDelayed(() -> {
            circularBar.setVisibility(View.GONE);
        }, 3000);
    }
}
