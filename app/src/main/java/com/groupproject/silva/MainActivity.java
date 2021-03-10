package com.groupproject.silva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    
    TextView sleeptext,infotext;
    ImageView sleepimg,infoimg;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        sleeptext = (TextView)findViewById(R.id.sleep_text);
        sleeptext.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {
                openSleepAnalysis();
            }
        });
        infotext = (TextView)findViewById(R.id.information_text);
        infotext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInfo();
            }
        });
        sleepimg = (ImageView)findViewById(R.id.imageView);
        sleepimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSleepAnalysis();
            }
        });
        sleepimg = (ImageView)findViewById(R.id.imageView2);
        sleepimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInfo();
            }
        });
    }
    
    private void openInfo() {
        Intent intent = new Intent(MainActivity.this, Information.class);
        startActivity(intent);
    }
    
    private void openSleepAnalysis() {
        Intent intent = new Intent(MainActivity.this, SleepAnalysis.class);
        startActivity(intent);
    }
}