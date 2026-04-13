package com.example.loginapp;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etUsername, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
    }

    public void loginUser(View view) {

        String user = etUsername.getText().toString().trim();
        String pass = etPassword.getText().toString().trim();

        if(user.equals("aditi") && pass.equals("aditi@123")){

            Intent intent = new Intent();
            intent.setComponent(new ComponentName(
                    "com.example.profileproject",
                    "com.example.profileproject.MainActivity"
            ));

            startActivity(intent);

        } else {
            Toast.makeText(MainActivity.this,
                    "Invalid Login",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
