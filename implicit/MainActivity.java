package com.example.assignment_4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnWebsite, btnCall, btnSMS, btnEmail, btnCamera, btnMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWebsite = findViewById(R.id.btnWebsite);
        btnCall = findViewById(R.id.btnCall);
        btnSMS = findViewById(R.id.btnSMS);
        btnEmail = findViewById(R.id.btnEmail);
        btnCamera = findViewById(R.id.btnCamera);
        btnMap = findViewById(R.id.btnMap);

        btnWebsite.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.google.com"));
            startActivity(intent);
        });

        btnCall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:9403234077"));
            startActivity(intent);
        });

        btnSMS.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("sms:9403234077"));
            intent.putExtra("sms_body", "Hello!");
            startActivity(intent);
        });

        btnEmail.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("message/rfc822");
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"example@gmail.com"});
            intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
            intent.putExtra(Intent.EXTRA_TEXT, "Hello from app");
            startActivity(Intent.createChooser(intent, "Send Email"));
        });

        btnCamera.setOnClickListener(v -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(intent);
        });

        btnMap.setOnClickListener(v -> {
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=Kolhapur");
            Intent intent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            intent.setPackage("com.google.android.apps.maps");
            startActivity(intent);
        });
    }
}
