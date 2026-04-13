package com.example.profile;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView profileImage;
    TextView nameText, emailText, phoneText, locationText, dobText;
    Button editProfileBtn;
    LinearLayout profileContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profileImage = findViewById(R.id.profileImage);
        nameText = findViewById(R.id.nameText);
        emailText = findViewById(R.id.emailText);
        phoneText = findViewById(R.id.phoneText);
        locationText = findViewById(R.id.locationText);
        dobText = findViewById(R.id.dobText);
        editProfileBtn = findViewById(R.id.editProfileBtn);
        profileContainer = findViewById(R.id.profileContainer);

        // Button Click Event
        editProfileBtn.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Edit Profile Clicked", Toast.LENGTH_SHORT).show();

            // Change background color on click
            int color = Color.rgb(
                    (int)(Math.random()*256),
                    (int)(Math.random()*256),
                    (int)(Math.random()*256)
            );
            profileContainer.setBackgroundColor(color);

            // Change name (example action)
            nameText.setText("Editing Mode...");
        });
    }
}
