package com.andi.eventapp;

import android.graphics.ColorSpace;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //addEvent();
        //einElement();
        childEvent();
    }

    public void addEvent() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference ref = db.getReference("events");
        ModellEvent event = new ModellEvent("Fasching in der Bürgerhalle",
                "Frankfurt", "Fasching", "September", "Null");
        ModellEvent event1 = new ModellEvent("Fasching in der Bürgerhalle",
                "Frankfurt", "Fasching", "September", "Null");
        ModellEvent event2 = new ModellEvent("Fasching in der Bürgerhalle",
                "Frankfurt", "Fasching", "September", "Null");
        ModellEvent event3 = new ModellEvent("Fasching in der Bürgerhalle",
                "Frankfurt", "Fasching", "September", "Null");
        ModellEvent event4 = new ModellEvent("Fasching in der Bürgerhalle",
                "Frankfurt", "Fasching", "September", "Null");
        ModellEvent event5 = new ModellEvent("Fasching in der Bürgerhalle",
                "Frankfurt", "Fasching", "September", "Null");
        ref.push().setValue(event);
        ref.push().setValue(event1);
        ref.push().setValue(event2);
        ref.push().setValue(event3);
        ref.push().setValue(event4);
        ref.push().setValue(event5);
    }

    public void einElement() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference ref = db.getReference("events");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot einElement : dataSnapshot.getChildren()){
                    ModellEvent m = einElement.getValue(ModellEvent.class);
                    Log.i("daten: ", m.getName());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void childEvent() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference ref = db.getReference("events");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                ModellEvent m = dataSnapshot.getValue(ModellEvent.class);
                String key = s;
                Log.i("daten", s + m.getName());

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                ModellEvent m = dataSnapshot.getValue(ModellEvent.class);
                String key = s;
                Log.i(" ######### daten: ", m.getName());
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
