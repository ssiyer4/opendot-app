package com.example.opendot_n.Location;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.opendot_n.Close;
import com.example.opendottest.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.Nullable;

public class AddLocation
        extends AppCompatActivity {

    private ImageView closeButton;

    private String StoredCoordinates;
    private String StoredLocation;

    private Button Addlocationbtn;

    //database reference
    private DatabaseReference mDatabase;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_location);

        //location node instead of root node
        mDatabase=FirebaseDatabase.getInstance().getReference("Locations");

        TextView enteredValue = (TextView) findViewById(R.id.location_name);

        // Show + store place name
        String passedName = getIntent().getExtras().getString("name");
        enteredValue.setText(passedName);
        StoredLocation = passedName;

        // Store the coordinates
        StoredCoordinates = getIntent().getExtras().getString("coordinates");


        Log.d("Coordinates of location:", StoredCoordinates);
        Log.d("Name of location", StoredLocation);

        closeButton = (ImageView) findViewById(R.id.ic_close);

        Close.setCloseButton(closeButton, this);


        Addlocationbtn = (Button) findViewById(R.id.btn_addtocollection);
        Addlocationbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AddLocation.this, "Added to Collection", Toast.LENGTH_SHORT).show();

                //generates unique id everytime a new node is created
                String id = mDatabase.push().getKey();

                Log.d("unique location id", id);

                LocationDB newLocation = new LocationDB(id, StoredLocation, StoredCoordinates);
                mDatabase.child(id).setValue(newLocation);

                Log.d("Location in DB", StoredLocation);


            }
        });

    }





}


//class for realtime firebase

//Stupid spinner

    //String[] categories = {"To eat", "To do", "To see"};


    /*protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_location);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.categories, R.layout.add_location);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    /*public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {*/




















