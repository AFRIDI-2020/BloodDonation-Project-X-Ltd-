package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignUp4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up4);
    }

    public void goToSignUp5Activity(View view) {
        Intent intent = new Intent(SignUp4Activity.this, SignUp5Activity.class);
        startActivity(intent);
    }
}