package com.example.filehandling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail, etPassword, etConfirmPassword, etPhone, etDob, etAddress;
    Button btnSave, btnLoad;
    TextView tvResult;

    String fileName = "mytext.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        etPhone = findViewById(R.id.etPhone);
        etDob = findViewById(R.id.etDob);
        etAddress = findViewById(R.id.etAddress);

        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);
        tvResult = findViewById(R.id.tvResult);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String password = etPassword.getText().toString();
                String confirmPassword = etConfirmPassword.getText().toString();

                if (!password.equals(confirmPassword)) {
                    Toast.makeText(MainActivity.this,
                            "Password not matched!", Toast.LENGTH_SHORT).show();
                    return;
                }

                String data =
                        "Name: " + etName.getText().toString() + "\n" +
                                "Email: " + etEmail.getText().toString() + "\n" +
                                "Password: " + password + "\n" +
                                "Phone: " + etPhone.getText().toString() + "\n" +
                                "DOB: " + etDob.getText().toString() + "\n" +
                                "Address: " + etAddress.getText().toString();

                try {
                    FileOutputStream fos = openFileOutput(fileName, MODE_PRIVATE);
                    fos.write(data.getBytes());
                    fos.close();

                    Toast.makeText(MainActivity.this,
                            "Data Saved Successfully", Toast.LENGTH_SHORT).show();

                    clearFields();

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this,
                            "Error Saving Data", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StringBuilder stringBuilder = new StringBuilder();

                try {
                    FileInputStream fis = openFileInput(fileName);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

                    String line;
                    while ((line = reader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }

                    tvResult.setText(stringBuilder.toString());

                    Toast.makeText(MainActivity.this,
                            "Data Loaded Successfully", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this,
                            "No Data Found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void clearFields() {
        etName.setText("");
        etEmail.setText("");
        etPassword.setText("");
        etConfirmPassword.setText("");
        etPhone.setText("");
        etDob.setText("");
        etAddress.setText("");
    }
}
