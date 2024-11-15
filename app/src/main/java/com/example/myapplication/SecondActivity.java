package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText emailEditText, passwordEditText;
    private Button loginButton;
    private TextView registerLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Initialize views
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.btnLogin);
        registerLink = findViewById(R.id.registerLink);

        // Set login button click listener
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Simple validation
                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(SecondActivity.this, "Please enter email and password", Toast.LENGTH_SHORT).show();
                } else {
                    // Proceed with login (Add your authentication logic here)
                    Toast.makeText(SecondActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                    // You might want to navigate to the main activity or another appropriate screen here
                }
            }
        });

        // Set click listener for the register link
        registerLink.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.registerLink) {
            // Launch the ThirdActivity
            Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
            startActivity(intent);
        }
    }
}