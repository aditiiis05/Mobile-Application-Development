package com.example.profile;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView nameText, emailText, phoneText, locationText, dobText;
    Button editProfileBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText = findViewById(R.id.nameText);
        emailText = findViewById(R.id.emailText);
        phoneText = findViewById(R.id.phoneText);
        locationText = findViewById(R.id.locationText);
        dobText = findViewById(R.id.dobText);
        editProfileBtn = findViewById(R.id.editProfileBtn);

        editProfileBtn.setOnClickListener(v -> openEditDialog());
    }

    private void openEditDialog() {

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(30, 20, 30, 10);

        EditText nameInput = new EditText(this);
        nameInput.setHint("Name");
        nameInput.setText(nameText.getText());

        EditText emailInput = new EditText(this);
        emailInput.setHint("Email");
        emailInput.setText(emailText.getText());

        EditText phoneInput = new EditText(this);
        phoneInput.setHint("Phone");
        phoneInput.setText(phoneText.getText().toString().replace("Phone : ", ""));

        EditText locationInput = new EditText(this);
        locationInput.setHint("Location");
        locationInput.setText(locationText.getText().toString().replace("Location : ", ""));

        EditText dobInput = new EditText(this);
        dobInput.setHint("DOB");
        dobInput.setText(dobText.getText().toString().replace("DOB : ", ""));

        layout.addView(nameInput);
        layout.addView(emailInput);
        layout.addView(phoneInput);
        layout.addView(locationInput);
        layout.addView(dobInput);

        new AlertDialog.Builder(this)
                .setTitle("Edit Profile")
                .setView(layout)
                .setPositiveButton("Save", (dialog, which) -> {

                    nameText.setText(nameInput.getText().toString());
                    emailText.setText(emailInput.getText().toString());
                    phoneText.setText("Phone : " + phoneInput.getText().toString());
                    locationText.setText("Location : " + locationInput.getText().toString());
                    dobText.setText("DOB : " + dobInput.getText().toString());

                    Toast.makeText(this, "Profile Updated", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("Cancel", null)
                .show();
    }
}
