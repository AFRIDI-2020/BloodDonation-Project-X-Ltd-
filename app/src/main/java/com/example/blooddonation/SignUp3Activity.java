package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class SignUp3Activity extends AppCompatActivity {

    private RelativeLayout aPosLayout, aNegLayout, bPosLayout, bNegLayout, oPosLayout, oNegLayout, abPosLayout, abNegLayout;
    private String username, email, password, phoneNo, altPhoneNo, social, bloodGroup = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up3);

        username = getIntent().getStringExtra("username");
        email = getIntent().getStringExtra("email");
        password = getIntent().getStringExtra("password");
        phoneNo = getIntent().getStringExtra("phoneNo");
        altPhoneNo = getIntent().getStringExtra("altPhoneNo");
        social = getIntent().getStringExtra("social");

        init();

        aPosLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bloodGroup = "A+";
                aPosLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape_on_click));
                aNegLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                bPosLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                bNegLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                oPosLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                oNegLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                abPosLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                abNegLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
            }
        });

        aNegLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bloodGroup = "A-";
                aPosLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                aNegLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape_on_click));
                bPosLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                bNegLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                oPosLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                oNegLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                abPosLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                abNegLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
            }
        });

        bPosLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bloodGroup = "B+";
                aPosLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                aNegLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                bPosLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape_on_click));
                bNegLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                oPosLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                oNegLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                abPosLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                abNegLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
            }
        });

        bNegLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bloodGroup = "B-";
                aPosLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                aNegLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                bPosLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                bNegLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape_on_click));
                oPosLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                oNegLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                abPosLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                abNegLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
            }
        });

        oPosLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bloodGroup = "O+";
                aPosLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                aNegLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                bPosLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                bNegLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                oPosLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape_on_click));
                oNegLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                abPosLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                abNegLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
            }
        });


        oNegLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bloodGroup = "O-";
                aPosLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                aNegLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                bPosLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                bNegLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                oPosLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                oNegLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape_on_click));
                abPosLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                abNegLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
            }
        });

        abPosLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bloodGroup = "AB+";
                aPosLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                aNegLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                bPosLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                bNegLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                oPosLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                oNegLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                abPosLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape_on_click));
                abNegLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
            }
        });

        abNegLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bloodGroup = "AB-";
                aPosLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                aNegLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                bPosLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                bNegLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                oPosLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                oNegLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                abPosLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape));
                abNegLayout.setBackground(getResources().getDrawable(R.drawable.text_view_round_shape_on_click));
            }
        });

    }

    private void init() {
        aPosLayout = findViewById(R.id.blood_group_1);
        aNegLayout = findViewById(R.id.blood_group_2);
        bPosLayout = findViewById(R.id.blood_group_3);
        bNegLayout = findViewById(R.id.blood_group_4);
        oPosLayout = findViewById(R.id.blood_group_5);
        oNegLayout = findViewById(R.id.blood_group_6);
        abPosLayout = findViewById(R.id.blood_group_7);
        abNegLayout = findViewById(R.id.blood_group_8);
    }

    public void goToSignUp4Activity(View view) {

        if(bloodGroup.equals("")){
            Toast.makeText(this, "Please select your blood group.", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            Intent intent = new Intent(SignUp3Activity.this, SignUp4Activity.class);
            intent.putExtra("username",username);
            intent.putExtra("email",email);
            intent.putExtra("password",password);
            intent.putExtra("phoneNo",phoneNo);
            intent.putExtra("altPhoneNo",altPhoneNo);
            intent.putExtra("social",social);
            intent.putExtra("bloodGroup",bloodGroup);
            startActivity(intent);
        }
    }
}