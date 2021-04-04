package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SignUp5Activity extends AppCompatActivity {

    private ConstraintLayout maleLayout, femaleLayout;
    private String username, email, password, phoneNo, altPhoneNo, social, bloodGroup,weight, gender = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up5);

        username = getIntent().getStringExtra("username");
        email = getIntent().getStringExtra("email");
        password = getIntent().getStringExtra("password");
        phoneNo = getIntent().getStringExtra("phoneNo");
        altPhoneNo = getIntent().getStringExtra("altPhoneNo");
        social = getIntent().getStringExtra("social");
        bloodGroup = getIntent().getStringExtra("bloodGroup");
        weight = getIntent().getStringExtra("weight");

        init();

        maleLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender = "male";
                maleLayout.setBackground(getResources().getDrawable(R.drawable.weight_card_view_bg_on_click));
                femaleLayout.setBackground(getResources().getDrawable(R.drawable.weight_cardview_bg));
            }
        });

        femaleLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender = "female";
                maleLayout.setBackground(getResources().getDrawable(R.drawable.weight_cardview_bg));
                femaleLayout.setBackground(getResources().getDrawable(R.drawable.weight_card_view_bg_on_click));
            }
        });
    }

    private void init() {
        maleLayout = findViewById(R.id.maleLayout);
        femaleLayout = findViewById(R.id.femaleLayout);
    }

    public void goToSignUp6Activity(View view) {

        if(gender.equals("")){
            Toast.makeText(this, "Please select your gender.", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            Intent intent = new Intent(SignUp5Activity.this, SignUp6Activity.class);
            intent.putExtra("username",username);
            intent.putExtra("email",email);
            intent.putExtra("password",password);
            intent.putExtra("phoneNo",phoneNo);
            intent.putExtra("altPhoneNo",altPhoneNo);
            intent.putExtra("social",social);
            intent.putExtra("bloodGroup",bloodGroup);
            intent.putExtra("weight",weight);
            intent.putExtra("gender",gender);
            startActivity(intent);
        }
    }
}