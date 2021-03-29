package com.example.blooddonation.custom;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.blooddonation.R;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    public int[] slideImages = {
            R.drawable.splash_img_1,
            R.drawable.splash_img_2
    };


    public String[] slideHeadline = {
            "Donate Blood",
            "Save Life"
    };

    public String[] slideDescription = {
            "You do not need to be a doctor to save lives. Just donate blood. Its safe, its simple and every blood donor is a life saver.",
            "Excuses never save a life, blood donation does. Get connected with blood donors and be a donor. \"Donate Blood\" app will help you to have that opportunity and save a life."
    };

    public String[] colors = {
            "#EF1A1A",
            "#FF6200EE"
    };

    @Override
    public int getCount() {
        return slideHeadline.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImage = view.findViewById(R.id.slide_image);
        TextView slideHeader = view.findViewById(R.id.label_donate_blood);
        TextView slideDes = view.findViewById(R.id.donate_blood_des);
        ConstraintLayout cardLayout = view.findViewById(R.id.cardLayout);

        slideImage.setImageResource(slideImages[position]);
        slideHeader.setText(slideHeadline[position]);
        slideDes.setText(slideDescription[position]);
        cardLayout.setBackgroundColor(Color.parseColor(colors[position]));

        container.addView(view);

        return view;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
