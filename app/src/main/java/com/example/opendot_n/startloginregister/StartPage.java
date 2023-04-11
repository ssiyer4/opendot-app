package com.example.opendot_n.startloginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.opendottest.R;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
public class StartPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        //Initialising the buttons on our start page: "Login" and "Register"
        Button login_btn_openpage = (Button) findViewById(R.id.loginButtonOpenPage);
        Button register_btn_openpage = (Button) findViewById(R.id.registerButtonOpenPage);

        //Sending user to login page if the login button is clicked
        login_btn_openpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: user has clicked login");
                Intent intent = new Intent(getApplicationContext(), LoginPage.class);
                startActivity(intent);

            }
        });

        //Sending user to registration page if the login button is clicked
        register_btn_openpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterPage.class);
                startActivity(intent);

            }
        });
    }
}