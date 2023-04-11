package com.example.opendot_n.startloginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.opendot_n.homeSwipe;
import com.example.opendottest.R;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPage extends AppCompatActivity {

    //Initialising the FirebaseAuth database as a variable called mAuth
    FirebaseAuth mAuth;

//TODO: See if the user is already signed in and figure out how to use username instead of email ID

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        TextView TextViewemail_login = (TextView) findViewById(R.id.usernameemailLoginPage);
        TextView TextViewpassword_login = (TextView) findViewById(R.id.passwordLoginPage);
        TextView TextViewBackBtn_login = (TextView) findViewById(R.id.backClickableTVLoginPage);

        Button login_btn_login = (Button) findViewById(R.id.loginButtonLoginPage);

        TextViewBackBtn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StartPage.class);
                startActivity(intent);
                finish();
            }
        });

        login_btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email_LOGIN = TextViewemail_login.getText().toString();
                String password_LOGIN = TextViewpassword_login.getText().toString();

                mAuth = FirebaseAuth.getInstance();

                if(TextUtils.isEmpty(email_LOGIN)){
                    Toast.makeText(LoginPage.this, "Enter an email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(password_LOGIN)){
                    Toast.makeText(LoginPage.this, "Enter a password", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.signInWithEmailAndPassword(email_LOGIN, password_LOGIN)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(LoginPage.this, "Log-in successful", Toast.LENGTH_SHORT).show();

                                    //TODO Set the Intent to take to the next page, which is card-swiping
                                    //DONE!! but homeSwipe is empty for now lol
                                    Intent intent = new Intent(getApplicationContext(), homeSwipe.class);
                                    startActivity(intent);
                                    finish();

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(LoginPage.this, "Log-in failed", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });

            }
        });


    }
}