package com.example.opendottest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> s;
    ArrayAdapter arrayAdapter;
    int n=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello xxx World!");

        s=new ArrayList<String>();
        s.add("AAA");
        s.add("BBB");
        s.add("CCC");
        s.add("DDD");
        s.add("EEE");
        s.add("FFF");
        s.add("GGG");
        SwipeFlingAdapterView swipeFlingAdapterView=(SwipeFlingAdapterView) findViewById(R.id.card);

        arrayAdapter = new ArrayAdapter<String>(this,R.layout.details,R.id.textView,s);
        swipeFlingAdapterView.setAdapter(arrayAdapter);
        swipeFlingAdapterView.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                s.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object o) {

            }

            @Override
            public void onRightCardExit(Object o) {

            }

            @Override
            public void onAdapterAboutToEmpty(int i) {

            }

            @Override
            public void onScroll(float v) {

            }
        });
    }
}