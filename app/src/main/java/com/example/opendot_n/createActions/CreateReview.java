package com.example.opendot_n.createActions;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.example.opendot_n.Close;
import com.example.opendottest.R;
import com.example.opendot_n.Review;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.RectangularBounds;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;

import java.util.Arrays;



public class CreateReview extends CreateMenu {

    private ImageView closeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_review);

        closeButton = (ImageView) findViewById(R.id.ic_close);

        Close.setCloseButton(closeButton, this);

        setupAutoCompleteFragment();

    }


    /// AUTOCOMPLETE SUGGESTIONS ///
    // sample codes from https://developers.google.com/maps/documentation/places/android-sdk/autocomplete
    public void setupAutoCompleteFragment(){
        // Initialize SDK
        String apiKey = getString(R.string.api_key); //api_key in strings.xml

        if(!Places.isInitialized()){
            Places.initialize(getApplicationContext(),apiKey);
        }

        PlacesClient placesClient = Places.createClient(this);


        //Initialize the AutocompleteSupportFragment.
        AutocompleteSupportFragment autocompleteFragment = (AutocompleteSupportFragment)
                getSupportFragmentManager().findFragmentById(R.id.autocomplete_fragment);


        // Specify the types of place data to return (singapore)
        autocompleteFragment.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME));

        autocompleteFragment.setLocationBias(RectangularBounds.newInstance(
                new LatLng(1.290270,103.851959),
                new LatLng(1.290270,103.851959)
        ));

        // Set up a PlaceSelectionListener to handle the response.
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(@NonNull Place place) {
                // pass the place name to review.java
                /*Intent intent = new Intent(CreateReview.this, Review.class);
                intent.putExtra("place", place.getName());
                Log.d("name", place.getName());
                startActivity(intent); */
                Intent intent = new Intent(CreateReview.this, Review.class);
                startActivity(intent);
            }

            @Override
            public void onError(@NonNull Status status) {
                // Handle the error.
                Log.e("Error", status.getStatusMessage());
            }
        });

    }

}
