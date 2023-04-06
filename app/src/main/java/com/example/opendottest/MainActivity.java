package com.example.opendottest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore firestore;

    ArrayList<String> s;
    ArrayAdapter arrayAdapter;
    int n=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialising Firestore
        firestore = FirebaseFirestore.getInstance();

        // Test cases for database
        Map<String,Object> users = new HashMap<>();
        users.put("UserID", "Alice");
        users.put("EmailID", "blank@gmail.com");
        users.put("Password", "123456789");
        users.put("List of Collection", "Visited, Beach, Western, Chinese");
        users.put("List of Reviews", "This place is so nice!");

        firestore.collection("users").add(users).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Failure", Toast.LENGTH_LONG).show();
            }
        });


        Map<String,Object> Location = new HashMap<>();
        Location.put("LocationID", "269");
        Location.put("Name", "Universal Studios Singapore");
        Location.put("Address", "8 Sentosa Gateway");
        Location.put("Category", "Entertainment, Family");
        Location.put("List of Reviews", "This place is so nice!");

        firestore.collection("Location").add(Location).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Failure", Toast.LENGTH_LONG).show();
            }
        });


        Map<String,Object> Collections = new HashMap<>();
        Collections.put("LocationID", "269");
        Collections.put("CollectionsID", "24");

        firestore.collection("Collections").add(Collections).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Failure", Toast.LENGTH_LONG).show();
            }
        });


        Map<String,Object> Review = new HashMap<>();
        Review.put("ReviewID", "#31");
        Review.put("Review Text", "This place is so nice!");
        Review.put("Rating", "5 Stars");
        Review.put("LocationID", "269");
        Review.put("UserID", "Alice");

        firestore.collection("Review").add(Review).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Failure", Toast.LENGTH_LONG).show();
            }
        });
        // Write a message to the database
        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        //DatabaseReference myRef = database.getReference("message");

        //myRef.setValue("Hello xxx World!");

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