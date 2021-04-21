package com.groupproject.silva;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int tabs;
    public PagerAdapter(FragmentManager fm, int NumOfTabs)
    {
        super(fm);
        this.tabs = NumOfTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                TutorialFragment tutorialFragment = new TutorialFragment();
                return tutorialFragment;

            case 1:
                InfoFragment infoFragment = new InfoFragment();
                return infoFragment;

            case 2:
                AboutFragment aboutFragment = new AboutFragment();
                return aboutFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabs;
    }
}
