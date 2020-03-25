package com.example.cookconvert;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calcButton = findViewById(R.id.calcButton);
        final TextView resultsTextView = findViewById(R.id.resultsTextView);
        final TextInputEditText originalRecipe = findViewById(R.id.original);
        final TextInputEditText desiredRecipe = findViewById(R.id.desired);
        Button conversionButton = findViewById(R.id.conversionButton);
        final TextInputEditText conversionAmount = findViewById(R.id.conversionAmount);
        final TextView convertedTextView = findViewById(R.id.convertedTextView);
        final Double[] conversionFactor = new Double[1];
        final DecimalFormat f = new DecimalFormat("##.00");

        calcButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Double original = Double.parseDouble(originalRecipe.getText().toString());
                Double desired = Double.parseDouble(desiredRecipe.getText().toString());
                conversionFactor[0] = (desired / original);
                resultsTextView.setText(f.format(conversionFactor[0]).toString());
            }
        });

        conversionButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Double oldAmount = Double.parseDouble(conversionAmount.getText().toString());
                Double newAmount = oldAmount * conversionFactor[0];
                convertedTextView.setText(f.format(newAmount));
            }
        });
    }
}
