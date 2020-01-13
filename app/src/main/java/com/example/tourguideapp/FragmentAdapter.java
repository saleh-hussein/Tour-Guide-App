package com.example.tourguideapp;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FragmentAdapter extends FragmentPagerAdapter {

    //declare context to use it with Tab title (with gat page title method in this class)
    private Context mContext;

   //constructor
    public FragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    //link the fragment with its position
    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new FragmentOne();
        }else if(position == 1){
            return new FragmentTwo();
        }else if(position == 2){
            return new FragmentThree();
        }else return new FragmentFour();
    }

   //declare how many fragments should appear
    @Override
    public int getCount() {
        return 4;
    }

    //set Tab title. (get tab title from resource R.string)
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return mContext.getString(R.string.tab_1);
        }else if(position == 1){
            return mContext.getString(R.string.tab_2);
        }else if(position == 2){
            return mContext.getString(R.string.tab_3);
        }else return mContext.getString(R.string.tab_4);
    }
}
