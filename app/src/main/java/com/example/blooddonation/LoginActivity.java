package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private TextView forgetPassTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
    }

    private void init() {
        forgetPassTV = findViewById(R.id.tv_forget_password);
        forgetPassTV.setPaintFlags(forgetPassTV.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
    }
}