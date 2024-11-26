package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class ThirteenActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RoomAdapter roomAdapter;
    private List<Room> roomList;
    private Button searchButton;
    private EditText searchBar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirteen);

        recyclerView = findViewById(R.id.room_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        roomList = new ArrayList<>();
        roomAdapter = new RoomAdapter(roomList);
        recyclerView.setAdapter(roomAdapter);

        DatabaseReference roomsRef = FirebaseDatabase.getInstance().getReference("Rooms");

        roomsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                roomList.clear();
                for (DataSnapshot roomSnapshot : dataSnapshot.getChildren()) {
                    Room room = roomSnapshot.getValue(Room.class);
                    if (room != null) {
                        roomList.add(room);
                    } else {
                        Toast.makeText(ThirteenActivity.this, "Error fetching room data", Toast.LENGTH_SHORT).show();
                    }
                }
                roomAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(ThirteenActivity.this, "Error fetching room data: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }


    }
