package com.example.opendot_v1;


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
import com.google.firebase.auth.FirebaseUser;

public class RegisterPage extends AppCompatActivity {

    FirebaseAuth mAuth;

//TODO: See if the user is already signed in and figure out how to use username instead of email ID

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        TextView TextViewemail_register = (TextView) findViewById(R.id.usernameemailRegisterPage);
        TextView TextViewpassword_register = (TextView) findViewById(R.id.passwordRegisterPage);
        TextView TextViewBackBtn_register = (TextView) findViewById(R.id.backClickableTVRegisterPage);

        Button register_btn = (Button) findViewById(R.id.registerButtonRegisterPage);

        TextViewBackBtn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OpeningPage.class);
                startActivity(intent);
                finish();
            }
        });


        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email_register = TextViewemail_register.getText().toString();
                String password_register = TextViewpassword_register.getText().toString();

                mAuth = FirebaseAuth.getInstance();

                if(TextUtils.isEmpty(email_register)){
                    Toast.makeText(RegisterPage.this, "Enter an email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(password_register)){
                    Toast.makeText(RegisterPage.this, "Enter a password", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email_register, password_register)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information

                                    FirebaseUser user = mAuth.getCurrentUser();

                                    Toast.makeText(RegisterPage.this, "Registration Successful", Toast.LENGTH_SHORT).show();

                                } else {
                                    // If sign in fails, display a message to the user.

                                    Toast.makeText(RegisterPage.this, "Registration failed", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
            }
        });
    }
}