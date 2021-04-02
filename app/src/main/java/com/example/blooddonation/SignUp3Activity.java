package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignUp3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up3);
    }

    public void goToSignUp4Activity(View view) {
        Intent intent = new Intent(SignUp3Activity.this, SignUp4Activity.class);
        startActivity(intent);
    }
}