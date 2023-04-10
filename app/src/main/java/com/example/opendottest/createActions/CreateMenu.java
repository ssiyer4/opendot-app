package com.example.opendottest.createActions;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.opendottest.Close;
import com.example.opendottest.R;
import com.example.opendottest.Review;
import com.example.opendottest.navBar;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class CreateMenu extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int ERROR_DIALOGUE_REQUEST = 9001;

    private ImageView closeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_menu);
        closeButton = (ImageView) findViewById(R.id.ic_close);
        Close.setCloseButton(closeButton, this);

        if (isServicesOK()){
            init();
        }
    }

    private void init(){

        //create menu buttons (3) declared below
        //button to create new location (opens map)
        Button btnMap = findViewById(R.id.btnMap);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateMenu.this, CreateLocation.class);
                startActivity(intent);
            }
        });


        Button btnReview = findViewById(R.id.btnReview);
        btnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateMenu.this, CreateReview.class);
                startActivity(intent);
            }
        });

        Button btnCollection = findViewById(R.id.btnCollection);
        btnCollection.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateMenu.this,CreateCollection.class);
                startActivity(intent);
            }
        });







    }

    //clicking cross icon
    //TODO: make this button lol fkin stupid
    public void goNavMain(MenuItem item){
        Log.d(TAG, "goNavMain: navigate back to main swiping page");
        Intent intent = new Intent(CreateMenu.this, navBar.class);
        startActivity(intent);
    }







    public boolean isServicesOK(){
        Log.d(TAG, "isServicesOK: checking google services version");
        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(CreateMenu.this);
        if (available== ConnectionResult.SUCCESS){
            //everything is fine -- user has same version of google play services
            Log.d(TAG, "isServicesOK: Google Play Services is working -- user has same version");
            return true;
        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            // an error occurred but we can resolve it -- this is a versioning issue
            Log.d(TAG, "isServicesOK: an error occurred, but this can be fixed");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(CreateMenu.this, available, ERROR_DIALOGUE_REQUEST);
            dialog.show();
        }
        else {
            Toast.makeText(this, "You can't make map requests", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

}