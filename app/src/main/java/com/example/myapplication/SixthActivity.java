package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SixthActivity extends AppCompatActivity {

    private Button bookNowButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);


        bookNowButton = findViewById(R.id.bookNowButton);



        bookNowButton.setOnClickListener(v -> {
            // When "Book Now" button is clicked, start FifthActivity
            Intent intent = new Intent(SixthActivity.this, TenActivity.class);
            startActivity(intent);
        });
    }
}