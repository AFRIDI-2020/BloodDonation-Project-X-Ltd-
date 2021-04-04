package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class SignUp1Activity extends AppCompatActivity {

    private TextInputLayout usernameTIL, emailTIL, passwordTIL;
    private String username, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up1);

        init();

    }

    public boolean validateUsername(){
        username = usernameTIL.getEditText().getText().toString();
        if(username.isEmpty()){
            Toast.makeText(this, "Username is required!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else {
            return true;
        }
    }

    public boolean validateEmail(){
        email = emailTIL.getEditText().getText().toString();
        if(email.isEmpty()){
            Toast.makeText(this, "Email is required!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else {
            return true;
        }
    }

    public boolean validatePassword(){
        password = passwordTIL.getEditText().getText().toString();
        if(password.isEmpty()){
            Toast.makeText(this, "Please set a password.", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(password.length()<6){
            Toast.makeText(this, "Password must be of six digits!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else {
            return true;
        }
    }

    private void init() {
        usernameTIL = findViewById(R.id.username_text_input_layout);
        emailTIL = findViewById(R.id.email_text_input_layout);
        passwordTIL = findViewById(R.id.password_text_input_layout);
    }

    public void goToSignUp2Activity(View view) {
        if(!validateUsername() || !validateEmail() || !validatePassword()){
            return;
        }
        else{

            username = usernameTIL.getEditText().getText().toString();
            email = emailTIL.getEditText().getText().toString();
            password = passwordTIL.getEditText().getText().toString();

            Intent intent = new Intent(SignUp1Activity.this, SignUp2Activity.class);
            intent.putExtra("username",username);
            intent.putExtra("email",email);
            intent.putExtra("password",password);
            startActivity(intent);
        }

    }
}