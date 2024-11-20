package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;





import androidx.appcompat.app.AppCompatActivity;

public class FouthActivity extends AppCompatActivity {
    private boolean isMainLayout = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fouth);

        // Initialize button
        Button seeAllButton = findViewById(R.id.see_all);
// Initialize Firebase Authentication
        seeAllButton.setOnClickListener(v -> {

            if (isMainLayout) {

                // Show a toast message

                Toast.makeText(FouthActivity.this, "Continue button clicked!", Toast.LENGTH_SHORT).show();



                // Switch to the second layout



                Intent intent = new Intent(FouthActivity.this, FifthActivity.class);

                startActivity(intent);

            } else {

                // Optionally, you can add logic to go back to the main layout if needed

                setContentView(R.layout.activity_fouth);

                isMainLayout = true; // Reset flag to indicate main layout is active again

            }





        });
        ImageView userImageView = findViewById(R.id.user);

        userImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FouthActivity.this, FifthActivity.class);
                startActivity(intent);

            }
        });
    }
}