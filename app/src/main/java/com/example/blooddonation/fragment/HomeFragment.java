package com.example.blooddonation.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.blooddonation.MyRequestActivity;
import com.example.blooddonation.PostRequestActivity;
import com.example.blooddonation.R;
import com.example.blooddonation.UrgentRequestsActivity;
import com.example.blooddonation.custom.CampaignViewPagerAdapter;


public class HomeFragment extends Fragment {

    private ViewPager viewPager;
    private LinearLayout dotLayout;
    private int dotsCount;
    private ImageView[] dots;
    private RelativeLayout postRequestLayout, urgentReqLayout, myReqLayout;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        viewPager = view.findViewById(R.id.campaign_view_pager);
        dotLayout = view.findViewById(R.id.dotsLayout);
        postRequestLayout = view.findViewById(R.id.post_request_layout);
        urgentReqLayout = view.findViewById(R.id.urgent_req_layout);
        myReqLayout = view.findViewById(R.id.my_req_layout);

        CampaignViewPagerAdapter viewPagerAdapter = new CampaignViewPagerAdapter(getContext());
        viewPager.setAdapter(viewPagerAdapter);

        dotsCount = viewPagerAdapter.getCount();
        dots = new ImageView[dotsCount];

        for(int i = 0; i< dotsCount; i++){
            dots[i] = new ImageView(getContext());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(),R.drawable.non_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(12,0,12,0);
            dotLayout.addView(dots[i],params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getContext(),R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for(int i=0; i<dotsCount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(),R.drawable.non_active_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getContext(),R.drawable.active_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        postRequestLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), PostRequestActivity.class));
            }
        });

        urgentReqLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), UrgentRequestsActivity.class));
            }
        });

        myReqLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MyRequestActivity.class));
            }
        });



        return view;
    }
}