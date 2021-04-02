package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignUp6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up6);
    }

    public void goToSignUp7Activity(View view) {
        Intent intent = new Intent(SignUp6Activity.this, SignUp7Activity.class);
        startActivity(intent);
    }
}