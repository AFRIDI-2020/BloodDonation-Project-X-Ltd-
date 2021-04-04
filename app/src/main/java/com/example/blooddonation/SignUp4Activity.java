package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SignUp4Activity extends AppCompatActivity {

    private ConstraintLayout underWeightLayout, eligibleWeightLayout;
    private String username, email, password, phoneNo, altPhoneNo, social, bloodGroup,weight = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up4);

        username = getIntent().getStringExtra("username");
        email = getIntent().getStringExtra("email");
        password = getIntent().getStringExtra("password");
        phoneNo = getIntent().getStringExtra("phoneNo");
        altPhoneNo = getIntent().getStringExtra("altPhoneNo");
        social = getIntent().getStringExtra("social");
        bloodGroup = getIntent().getStringExtra("bloodGroup");

        init();

        underWeightLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weight = "below 50 KG";
                underWeightLayout.setBackground(getResources().getDrawable(R.drawable.weight_card_view_bg_on_click));
                eligibleWeightLayout.setBackground(getResources().getDrawable(R.drawable.weight_cardview_bg));
            }
        });

        eligibleWeightLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weight = "Above 50 KG";
                underWeightLayout.setBackground(getResources().getDrawable(R.drawable.weight_cardview_bg));
                eligibleWeightLayout.setBackground(getResources().getDrawable(R.drawable.weight_card_view_bg_on_click));
            }
        });
    }

    private void init() {
        underWeightLayout = findViewById(R.id.under_weight_layout);
        eligibleWeightLayout = findViewById(R.id.eligible_weight_layout);
    }

    public void goToSignUp5Activity(View view) {

        if(weight.equals("")){
            Toast.makeText(this, "Please select your current weight status.", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            Intent intent = new Intent(SignUp4Activity.this, SignUp5Activity.class);
            intent.putExtra("username",username);
            intent.putExtra("email",email);
            intent.putExtra("password",password);
            intent.putExtra("phoneNo",phoneNo);
            intent.putExtra("altPhoneNo",altPhoneNo);
            intent.putExtra("social",social);
            intent.putExtra("bloodGroup",bloodGroup);
            intent.putExtra("weight",weight);
            startActivity(intent);
        }
    }
}