package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignUp1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up1);
    }

    public void goToSignUp2Activity(View view) {
        Intent intent = new Intent(SignUp1Activity.this, SignUp2Activity.class);
        startActivity(intent);
    }
}