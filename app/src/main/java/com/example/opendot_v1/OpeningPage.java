package com.example.opendot_v1;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class OpeningPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening_page);
        Log.d(TAG, "onCreate: init");

        Button login_btn_openpage = (Button) findViewById(R.id.loginButtonOpenPage);
        Button register_btn_openpage = (Button) findViewById(R.id.registerButtonOpenPage);

        login_btn_openpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: user has clicked login");
                Intent intent = new Intent(getApplicationContext(), LoginPage.class);
                startActivity(intent);

            }
        });

        register_btn_openpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: user has clicked reg");
                Intent intent = new Intent(getApplicationContext(), RegisterPage.class);
                startActivity(intent);

            }
        });
    }
}