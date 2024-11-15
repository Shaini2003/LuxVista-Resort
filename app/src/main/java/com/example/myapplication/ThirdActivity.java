package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nameEditText, emailEditText, passwordEditText;
    private Button signUpButton;
    private TextView loginLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        // Initialize views
        nameEditText = findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        signUpButton = findViewById(R.id.signUpButton);
        loginLink = findViewById(R.id.loginLink);

        // Set click listener for the login link
        loginLink.setOnClickListener(this);

        // Set click listener for the sign up button
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement sign up logic here
                // You can get the user input from the EditText fields
                String name = nameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Perform validation and sign up process
                // ...

                // After successful sign-up, navigate to the login screen or home screen
                Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.loginLink) {
            Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
            startActivity(intent);
        }
    }
}