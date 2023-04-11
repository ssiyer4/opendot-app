package com.example.opendot_n.startloginregister;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.opendot_n.homeSwipe;
import com.example.opendottest.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterPage extends AppCompatActivity {

    //Initialising the FirebaseAuth database as a variable called mAuth
    FirebaseAuth mAuth;

//TODO: See if the user is already signed in and figure out how to use username instead of email ID

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        //Initialising the textViews and Button objects
        TextView TextViewemail_register = (TextView) findViewById(R.id.usernameemailRegisterPage);
        TextView TextViewpassword_register = (TextView) findViewById(R.id.passwordRegisterPage);
        TextView TextViewBackBtn_register = (TextView) findViewById(R.id.backClickableTVRegisterPage);

        Button register_btn = (Button) findViewById(R.id.registerButtonRegisterPage);

        //Sending user back to the "start" page if the "back" button is pressed
        TextViewBackBtn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StartPage.class);
                startActivity(intent);
                finish();
            }
        });


        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Initialising textView objects
                String email_register = TextViewemail_register.getText().toString();
                String password_register = TextViewpassword_register.getText().toString();

                //Returns an instance of this class corresponding to the default FirebaseApp instance
                mAuth = FirebaseAuth.getInstance();

                //Toast message to tell user that the email field is blank
                if(TextUtils.isEmpty(email_register)){
                    Toast.makeText(RegisterPage.this, "Enter an email", Toast.LENGTH_SHORT).show();
                    return;
                }

                //Toast message to tell user that the password field is blank
                if(TextUtils.isEmpty(password_register)){
                    Toast.makeText(RegisterPage.this, "Enter a password", Toast.LENGTH_SHORT).show();
                    return;
                }

                //Creating and storing a user with the specified email and password
                //CREDIT: Google Firebase documentation
                mAuth.createUserWithEmailAndPassword(email_register, password_register)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information

                                    FirebaseUser user = mAuth.getCurrentUser();

                                    Toast.makeText(RegisterPage.this, "Registration Successful", Toast.LENGTH_SHORT).show();

                                    //TODO Set the Intent to take to the next page, which is card-swiping
                                    //DONE!! but homeSwipe is empty for now lol
                                    Intent intent = new Intent(getApplicationContext(), homeSwipe.class);
                                    startActivity(intent);
                                    finish();

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