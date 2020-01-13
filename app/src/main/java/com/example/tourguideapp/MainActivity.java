package com.example.tourguideapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.widget.ListView;

//import com.google.android.material.tabs.TabLayout to use TabLayout
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declare viewPager and link it with xml
        ViewPager mViewPager = (ViewPager)findViewById(R.id.view_pager);

        //declare adapter
        FragmentAdapter mAdapter = new FragmentAdapter(this,getSupportFragmentManager());

        //set the view pager with adapter
        mViewPager.setAdapter(mAdapter);

        //declare tabLayout link it with xml
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab);

        //set the tabLayout with viewPager
        tabLayout.setupWithViewPager(mViewPager);
    }
}
