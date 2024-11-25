package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class TwelveActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private ProgressBar progressBar;
    private TextView errorTextView;

    private static final String VALID_EMAIL = "shinitharushika2020@gmail.com";
    private static final String VALID_PASSWORD = "1234se@";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twelve);

        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.btnLogin);
        progressBar = findViewById(R.id.progressBar);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                // Clear any previous errors
                errorTextView.setVisibility(View.GONE);

                // Show progress bar while validating
                progressBar.setVisibility(View.VISIBLE);

                // Simulate authentication (replace with actual authentication logic)
                if (email.equals(VALID_EMAIL) && password.equals(VALID_PASSWORD)) {
                    // Successful login, navigate to the second activity
                    Intent intent = new Intent(TwelveActivity.this, ThirteenActivity.class);
                    startActivity(intent);
                    finish(); // Finish the login activity
                } else {
                    // Invalid credentials, show error message
                    errorTextView.setVisibility(View.VISIBLE);
                    errorTextView.setText("Invalid email or password");
                }

                // Hide progress bar
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}
