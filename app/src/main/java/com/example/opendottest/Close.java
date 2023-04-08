package com.example.opendottest;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Close extends AppCompatActivity {

    // This method is referenced in all activities with the close button
    public static void setCloseButton(ImageView closeButton, Activity currentActivity) {

        closeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Closing page", Toast.LENGTH_SHORT).show();
                currentActivity.finish(); // current page is 'destroyed' and previous page is entered
            }
        });

    }

}
