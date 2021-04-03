package com.groupproject.silva;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class InfoActivity extends AppCompatActivity implements TutorialFragment.OnFragmentInteractionListener, InfoFragment.OnFragmentInteractionListener, QuizFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("Tutorial"));
        tabLayout.addTab(tabLayout.newTab().setText("Info"));
        tabLayout.addTab(tabLayout.newTab().setText("Quiz"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}