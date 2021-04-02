package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignUp5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up5);
    }

    public void goToSignUp6Activity(View view) {
        Intent intent = new Intent(SignUp5Activity.this, SignUp6Activity.class);
        startActivity(intent);
    }
}