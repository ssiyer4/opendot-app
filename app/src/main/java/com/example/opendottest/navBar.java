package com.example.opendottest;

// to create some function to help change colour of navbar depending on current activity

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.opendottest.createActions.CreateMenu;
import com.example.opendottest.profile.profilePage;

public class navBar extends AppCompatActivity {
    private static final String TAG = "navBar";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_navigation_menu, menu);
        return true;
        //return super.onCreateOptionsMenu(menu);
    }

    public void onNavCreateClick(MenuItem item){
        Intent intent = new Intent(navBar.this, CreateMenu.class);
        startActivity(intent);
    }

    public void onNavSwipeClick(MenuItem item){
        Log.d(TAG, "onNavSwipeClick: swipe");
        Toast.makeText(this, "swipe", Toast.LENGTH_SHORT).show();

    }

    public void onNavProfileClick(MenuItem item){
        Log.d(TAG, "onNavProfileClick: profile");
        Intent intent = new Intent(navBar.this, profilePage.class);
        startActivity(intent);

    }



}
