package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class SignUp2Activity extends AppCompatActivity {

    private TextInputLayout phoneNoTIL, altPhoneNoTIL, socialTIL;
    private String username, email,password, phoneNo, altPhoneNo, social;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        username = getIntent().getStringExtra("username");
        email = getIntent().getStringExtra("email");
        password = getIntent().getStringExtra("password");

        init();
    }

    private void init() {
        phoneNoTIL = findViewById(R.id.phone_no_text_input_layout);
        altPhoneNoTIL = findViewById(R.id.alt_phone_no_text_input_layout);
        socialTIL = findViewById(R.id.social_text_input_layout);
    }

    public boolean validatePhoneNo(){
        phoneNo = phoneNoTIL.getEditText().getText().toString();
        if(phoneNo.isEmpty()){
            Toast.makeText(this, "Phone No is required!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(phoneNo.length()!=11){
            Toast.makeText(this, "Phone no must be of 11 digits!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else
        {
            return true;
        }
    }

    public boolean validateAltPhoneNo(){
        altPhoneNo = altPhoneNoTIL.getEditText().getText().toString();
        if(altPhoneNo.isEmpty()){
            Toast.makeText(this, "Please provide an alternative phone no for emergency.", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(altPhoneNo.length()!=11){
            Toast.makeText(this, "Alternative phone no must be of 11 digits!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else
        {
            return true;
        }
    }

    public void goToSignUp3Activity(View view) {

        phoneNo = phoneNoTIL.getEditText().getText().toString();
        altPhoneNo = altPhoneNoTIL.getEditText().getText().toString();
        social = socialTIL.getEditText().getText().toString();

        if(!validatePhoneNo() || !validateAltPhoneNo()){
            return;
        }
        else{
            Intent intent = new Intent(SignUp2Activity.this, SignUp3Activity.class);
            intent.putExtra("username",username);
            intent.putExtra("email",email);
            intent.putExtra("password",password);
            intent.putExtra("phoneNo",phoneNo);
            intent.putExtra("altPhoneNo",altPhoneNo);
            intent.putExtra("social",social);
            startActivity(intent);
        }

    }
}