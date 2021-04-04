package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class SignUp6Activity extends AppCompatActivity {

    private TextInputLayout streetLayout, cityLayout, postalCodeLayout;
    private String username, email, password, phoneNo, altPhoneNo, social, bloodGroup,weight, gender, street, city, postalCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up6);

        username = getIntent().getStringExtra("username");
        email = getIntent().getStringExtra("email");
        password = getIntent().getStringExtra("password");
        phoneNo = getIntent().getStringExtra("phoneNo");
        altPhoneNo = getIntent().getStringExtra("altPhoneNo");
        social = getIntent().getStringExtra("social");
        bloodGroup = getIntent().getStringExtra("bloodGroup");
        weight = getIntent().getStringExtra("weight");
        gender = getIntent().getStringExtra("gender");

        init();

    }

    private void init() {
        streetLayout = findViewById(R.id.street_text_input_layout);
        cityLayout = findViewById(R.id.city_text_input_layout);
        postalCodeLayout = findViewById(R.id.postal_code_text_input_layout);
    }

    public boolean validateStreetAddress(){
        street = streetLayout.getEditText().getText().toString();

        if(street.isEmpty()){
            Toast.makeText(this, "Please write your street address.", Toast.LENGTH_SHORT).show();
            return false;
        }
        else {
            return true;
        }
    }

    public boolean validateCityAddress(){
        city = cityLayout.getEditText().getText().toString();

        if(city.isEmpty()){
            Toast.makeText(this, "Please write your city name.", Toast.LENGTH_SHORT).show();
            return false;
        }
        else{
            return true;
        }
    }


    public boolean validatePostalCode(){

        postalCode = postalCodeLayout.getEditText().getText().toString();

        if(postalCode.isEmpty()){
            Toast.makeText(this, "Please provide your postal code. ", Toast.LENGTH_SHORT).show();
            return false;
        }
        else{
            return true;
        }
    }

    public void goToSignUp7Activity(View view) {

        street = streetLayout.getEditText().getText().toString();
        city = cityLayout.getEditText().getText().toString();
        postalCode = postalCodeLayout.getEditText().getText().toString();

        if(!validateStreetAddress() || !validateCityAddress() || !validatePostalCode()){
            return;
        }
        else{
            Intent intent = new Intent(SignUp6Activity.this, SignUp7Activity.class);
            intent.putExtra("username",username);
            intent.putExtra("email",email);
            intent.putExtra("password",password);
            intent.putExtra("phoneNo",phoneNo);
            intent.putExtra("altPhoneNo",altPhoneNo);
            intent.putExtra("social",social);
            intent.putExtra("bloodGroup",bloodGroup);
            intent.putExtra("weight",weight);
            intent.putExtra("gender",gender);
            intent.putExtra("street",street);
            intent.putExtra("city",city);
            intent.putExtra("postalCode",postalCode);
            startActivity(intent);
        }
    }
}