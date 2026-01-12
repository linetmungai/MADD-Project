package com.example.project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // --- VARIABLES (The connectors to the screen) ---
    // We declare these here so the whole class can see them.
    private EditText etWeight; // Box for weight input
    private EditText etHeight; // Box for height input
    private TextView tvResult; // Text area to show the answer
    private Button btnCompute; // Button to calculate
    private Button btnReset;   // Button to clear (Your Feature)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // --- INITIALIZATION ---
        // Here we link the Java variables to the XML IDs.
        // NOTE: These IDs (etWeight, etHeight) will be RED until Member 2 creates the Layout.
        etWeight = findViewById(R.id.etWeight);
        etHeight = findViewById(R.id.etHeight);
        tvResult = findViewById(R.id.tvResult);
        btnCompute = findViewById(R.id.btnCompute);
        btnReset = findViewById(R.id.btnReset);

        // --- CLICK LISTENERS ---

        // 1. Logic for the Compute Button
        // (Member 4 and 5 will fill in the calculation logic inside here later)
        btnCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // For now, this is empty. The math team will work here.
            }
        });

        // 2. Logic for YOUR Reset Button
        // This is your specific technical contribution.
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFields(); // Calls the function you wrote below
            }
        });
    }

    // --- YOUR CUSTOM FUNCTION ---
    // This function wipes the text fields and resets the result text.
    private void clearFields() {
        etWeight.setText(""); // Clear weight
        etHeight.setText(""); // Clear height
        tvResult.setText(""); // Clear result

        // Optional: Put the cursor back in the weight box so the user can type immediately
        etWeight.requestFocus();
    }
}