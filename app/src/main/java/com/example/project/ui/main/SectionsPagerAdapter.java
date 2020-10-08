package com.example.project.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class SectionsPagerAdapter extends FragmentPagerAdapter {


    private final Context mContext;
    private final List<String> tabTitles = new ArrayList<>();
    public SectionsPagerAdapter(Context context, FragmentManager fm, TabLayout tabs) {
        super(fm);
        mContext = context;
        for(int i = 0; i < tabs.getTabCount(); i++){
            tabTitles.add(tabs.getTabAt(i).getText().toString());

        }
    }

    @Override
    public QuizFragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
//        return (Fragment) QuizFragment.PlaceholderFragment.newInstance(position + 1);
        switch (position){
            case 0: return QuizFragment.newInstance("nintendo");
            case 1: return QuizFragment.newInstance("playstation");
            case 2:
            default:return QuizFragment.newInstance("xbox");
        }

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles.get(position);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return tabTitles.size();
    }
}