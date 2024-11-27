package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

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

public class FifteenActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private OffersAdapter offersAdapter;
    private List<Offers> offersList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifteen);

        recyclerView = findViewById(R.id.offers);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        offersList = new ArrayList<>();
        offersAdapter = new OffersAdapter(offersList);
        recyclerView.setAdapter(offersAdapter);

        DatabaseReference offersRef = FirebaseDatabase.getInstance().getReference("Offers");

        offersRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                offersList.clear();
                for (DataSnapshot offerSnapshot : dataSnapshot.getChildren()) {
                    Offers offers = offerSnapshot.getValue(Offers.class);
                    if (offers != null) {
                        offersList.add(offers);
                    } else {
                        Toast.makeText(FifteenActivity.this, "Error fetching room data", Toast.LENGTH_SHORT).show();
                    }
                }
                offersAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(FifteenActivity.this, "Error fetching room data: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
