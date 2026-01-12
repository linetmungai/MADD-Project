package com.example.madd_project;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    // 🔹 Variable declarations
    EditText etWeight, etHeight;
    Button btnCompute, btnReset;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 🔹 Initialize views
        etWeight = findViewById(R.id.etWeight);
        etHeight = findViewById(R.id.etHeight);
        btnCompute = findViewById(R.id.btnCompute);
        btnReset = findViewById(R.id.btnReset);
        tvResult = findViewById(R.id.tvResult);

      
btnCompute.setOnClickListener(v -> {

    // 1. Capture inputs 
    String weightStr = etWeight.getText().toString().trim();
    String heightStr = etHeight.getText().toString().trim();

    // 2. VALIDATION 
    
    // Check Empty Weight
    if (weightStr.isEmpty()) {
        etWeight.setError("Weight is required!"); // specific error on the field
        etWeight.requestFocus(); 
        return;
    }

    // Check Empty Height
    if (heightStr.isEmpty()) {
        etHeight.setError("Height is required!");
        etHeight.requestFocus();
        return;
    }

    // Check Numeric Validity & Zero values
    try {
        double weight = Double.parseDouble(weightStr);
        double height = Double.parseDouble(heightStr);

        if (weight <= 0 || height <= 0) {
            // Toast or specific error for logic
            tvResult.setText("Error: Values must be greater than 0"); 
            return;
        }

        // Calculate BMI: BMI = weight(kg) / height(m)^2
        double bmi = weight / (height * height);

        // Determine category
        String category = getBMICategory(bmi);

        // Format BMI to 2 decimal places and include category
        String bmiResult = String.format("BMI: %.2f (%s)", bmi, category);

        // Display the result
        tvResult.setText(bmiResult);

    } catch (NumberFormatException e) {
        // Prevents crash if input is just "." or invalid chars
        tvResult.setText("Error: Invalid numeric input");
    }
});

        // 🔹 Reset button
        btnReset.setOnClickListener(v -> {
            etWeight.setText("");
            etHeight.setText("");
            tvResult.setText("");
        });
    }

    private String getBMICategory(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
