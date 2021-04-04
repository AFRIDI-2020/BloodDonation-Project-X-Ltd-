package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.shawnlin.numberpicker.NumberPicker;

public class SignUp7Activity extends AppCompatActivity {

    private NumberPicker numberPicker,numberPicker2, monthPicker;
    private String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul","Aug","Sep","Oct","Nov","Dec"};

    private String age, date, month, birthDate;
    private String username, email, password, phoneNo, altPhoneNo, social, bloodGroup,weight, gender,street, city, postalCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up7);


        username = getIntent().getStringExtra("username");
        email = getIntent().getStringExtra("email");
        password = getIntent().getStringExtra("password");
        phoneNo = getIntent().getStringExtra("phoneNo");
        altPhoneNo = getIntent().getStringExtra("altPhoneNo");
        social = getIntent().getStringExtra("social");
        bloodGroup = getIntent().getStringExtra("bloodGroup");
        weight = getIntent().getStringExtra("weight");
        gender = getIntent().getStringExtra("gender");
        street = getIntent().getStringExtra("street");
        city = getIntent().getStringExtra("city");
        postalCode = getIntent().getStringExtra("postalCode");

        numberPicker = findViewById(R.id.number_picker);
        numberPicker2 = findViewById(R.id.number_picker2);
        monthPicker = findViewById(R.id.month_picker);
        numberPicker.setSelectedTextColor(ContextCompat.getColor(this,R.color.black));
        numberPicker.setTextColor(ContextCompat.getColor(this,R.color.ash));
        numberPicker.setMaxValue(65);
        numberPicker.setMinValue(17);
        numberPicker.setValue(25);
        numberPicker.setFadingEdgeEnabled(false);
        numberPicker.setWrapSelectorWheel(true);

        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                age = String.valueOf(newVal);
            }
        });

        numberPicker2.setSelectedTextColor(ContextCompat.getColor(this,R.color.black));
        numberPicker2.setTextColor(ContextCompat.getColor(this,R.color.ash));
        numberPicker2.setMaxValue(31);
        numberPicker2.setMinValue(1);
        numberPicker2.setValue(15);
        numberPicker2.setFadingEdgeEnabled(false);
        numberPicker2.setWrapSelectorWheel(true);

        numberPicker2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                date = String.valueOf(newVal);
            }
        });

        monthPicker.setMinValue(1);
        monthPicker.setMaxValue(months.length);
        monthPicker.setDisplayedValues(months);
        monthPicker.setValue(6);
        monthPicker.setSelectedTextColor(ContextCompat.getColor(this,R.color.black));
        monthPicker.setTextColor(ContextCompat.getColor(this,R.color.ash));
        monthPicker.setFadingEdgeEnabled(false);
        monthPicker.setWrapSelectorWheel(true);

        monthPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                month = String.valueOf(newVal);
            }
        });


    }

    public void goToSignUp8Activity(View view) {

        birthDate = date + " " + month;

        Intent intent = new Intent(SignUp7Activity.this, SignUp8Activity.class);
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
        intent.putExtra("age",age);
        intent.putExtra("birthDate", birthDate);
        startActivity(intent);
    }
}