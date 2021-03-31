package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private TextView forgetPassTV,signUPTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();

        signUPTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUp1Activity.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        forgetPassTV = findViewById(R.id.tv_forget_password);
        signUPTV = findViewById(R.id.signUpTV);
        forgetPassTV.setPaintFlags(forgetPassTV.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
    }
}