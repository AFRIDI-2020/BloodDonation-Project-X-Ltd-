package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.blooddonation.custom.SliderAdapter;

public class SplashScreenActivity extends AppCompatActivity {

    private ViewPager slideViewPager;
    private SliderAdapter sliderAdapter;
    private LinearLayout dotLayout;
    private Button nextBtn;

    private TextView[] dots;
    private int currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        slideViewPager = findViewById(R.id.slide_view_pager);
        dotLayout = findViewById(R.id.dotLayout);
        nextBtn = findViewById(R.id.nextBtn);
        sliderAdapter = new SliderAdapter(this);
        slideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);
        slideViewPager.addOnPageChangeListener(viewListener);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(slideViewPager.getCurrentItem()+1 < dots.length){
                    slideViewPager.setCurrentItem(currentPage + 1);
                }else {
                    startActivity(new Intent(SplashScreenActivity.this, LoginActivity.class));
                }
            }
        });
    }

    private void addDotsIndicator(int position) {
        dots = new TextView[2];
        dotLayout.removeAllViews();
        for(int i=0; i<dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(36);
            dots[i].setTextColor(getResources().getColor(R.color.transparentWhite));
            dotLayout.addView(dots[i]);
        }

        if(dots.length>0){
            dots[position].setTextColor(getResources().getColor(R.color.white));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addDotsIndicator(position);
            currentPage = position;

            if(position == 0){
                nextBtn.setText("Next");
            }
            if(position == 1){
                nextBtn.setText("Start");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}