package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class EleventhActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleven);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        databaseReference = FirebaseDatabase.getInstance().getReference("Services");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Rename the method here (e.g., processData)
                processData(dataSnapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("FirebaseData", "Failed to read services.", error.toException());
            }

            private void processData(DataSnapshot dataSnapshot) {
                // Your logic to handle the retrieved data
                List<HotelService> servicesList = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    HotelService service = snapshot.getValue(HotelService.class);
                    servicesList.add(service);
                }

                // Update your adapter with the servicesList
                // ...
            }
        });
    }
}