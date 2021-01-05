package com.example.amazonprime;

import android.widget.BaseAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FrgamenAddapter extends FragmentPagerAdapter {
    public FrgamenAddapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                homefrg homefrg=new homefrg();
                return homefrg;
            case 1:
                Tvshowfrg tvshowfrg=new Tvshowfrg();
                return tvshowfrg;
            case 2:
                Movie movie=new Movie();
                return movie;
            case 3:
                Kids kids=new Kids();
                return kids;
            default:return null;
        }

    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
            return "home";
            case 1:
                return "TvShows";
            case 2:
                return "Movie";
            case 3:
                return "Kids";
            default:return null;
        }
    }
}
