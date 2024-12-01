package com.example.myapplication;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class EditPromotionActivity extends AppCompatActivity {

    private EditText roomNameEditText;
    private Button saveButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_promotion);

        roomNameEditText = findViewById(R.id.promotion_image_edit);
        saveButton = findViewById(R.id.save_button);


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRoomDetails();
            }
        });
    }

    private void updateRoomDetails() {

        String roomName =  roomNameEditText.getText().toString().trim();




        if (TextUtils.isEmpty(roomName)) {
            Toast.makeText(this, "Room Name is required", Toast.LENGTH_SHORT).show();
            return;
        }

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Promotions").child(roomName);

        Map<String, Object> updatedValues = new HashMap<>();
        if (!TextUtils.isEmpty(roomName)) updatedValues.put("name", roomName);


        databaseReference.updateChildren(updatedValues).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Toast.makeText(EditPromotionActivity.this, "Promotion details updated successfully!", Toast.LENGTH_SHORT).show();
                clearFields();
            } else {
                Toast.makeText(EditPromotionActivity.this, "Failed to update: " + task.getException(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void clearFields() {
        roomNameEditText.setText("");

    }
}
