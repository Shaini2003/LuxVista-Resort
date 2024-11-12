package com.example.myapplication;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;





public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize button
        Button continueButton = findViewById(R.id.continueButton);

        // Set button click listener
        continueButton.setOnClickListener(v -> {
            // Handle button click, for now, show a simple toast
            Toast.makeText(MainActivity.this, "Continue button clicked!", Toast.LENGTH_SHORT).show();
        });
    }
}