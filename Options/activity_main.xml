package com.example.assignment_3;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CheckBox cbPizza, cbBurger, cbPasta;
    RadioGroup radioGroup;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbPizza = findViewById(R.id.cbPizza);
        cbBurger = findViewById(R.id.cbBurger);
        cbPasta = findViewById(R.id.cbPasta);
        radioGroup = findViewById(R.id.radioGroup);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v -> {

            StringBuilder result = new StringBuilder("Selected Food: ");

            if (cbPizza.isChecked()) result.append("Pizza ");
            if (cbBurger.isChecked()) result.append("Burger ");
            if (cbPasta.isChecked()) result.append("Pasta ");

            int selectedId = radioGroup.getCheckedRadioButtonId();

            String payment = "";
            if (selectedId != -1) {
                RadioButton rb = findViewById(selectedId);
                payment = rb.getText().toString();
            }

            Toast.makeText(this,
                    result + "\nPayment: " + payment,
                    Toast.LENGTH_LONG).show();
        });
    }
}
