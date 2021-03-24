package com.groupproject.silva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Pop_up_sleepActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_sleep);
        getActionBar().hide();
    }
}