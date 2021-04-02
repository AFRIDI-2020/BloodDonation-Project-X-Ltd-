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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up7);

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

        numberPicker2.setSelectedTextColor(ContextCompat.getColor(this,R.color.black));
        numberPicker2.setTextColor(ContextCompat.getColor(this,R.color.ash));
        numberPicker2.setMaxValue(31);
        numberPicker2.setMinValue(1);
        numberPicker2.setValue(15);
        numberPicker2.setFadingEdgeEnabled(false);
        numberPicker2.setWrapSelectorWheel(true);

        monthPicker.setMinValue(1);
        monthPicker.setMaxValue(months.length);
        monthPicker.setDisplayedValues(months);
        monthPicker.setValue(6);
        monthPicker.setSelectedTextColor(ContextCompat.getColor(this,R.color.black));
        monthPicker.setTextColor(ContextCompat.getColor(this,R.color.ash));
        monthPicker.setFadingEdgeEnabled(false);
        monthPicker.setWrapSelectorWheel(true);


    }

    public void goToSignUp8Activity(View view) {
        Intent intent = new Intent(SignUp7Activity.this, SignUp8Activity.class);
        startActivity(intent);
    }
}