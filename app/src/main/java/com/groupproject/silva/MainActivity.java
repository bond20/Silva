package com.groupproject.silva;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.groupproject.silva.to_do_model.TaskViewInterface;

public class MainActivity extends AppCompatActivity {


    
    TextView sleeptext,infotext;
    ImageView sleepimg,infoimg, toDoImg, calendarImg;
    
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
        sleepimg = (ImageView)findViewById(R.id.SleepAnalysisIcon);
        sleepimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSleepAnalysis();
            }
        });
        infoimg = (ImageView)findViewById(R.id.InformationIcon);
        infoimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInfo();
            }
        });

        toDoImg = (ImageView)findViewById(R.id.ToDoIcon);
        toDoImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openToDO();
            }
        });

        calendarImg = (ImageView)findViewById(R.id.CalendarIcon);
        calendarImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEventCalendar();
            }
        });

    }
    
    private void openInfo() {
        Intent intent = new Intent(MainActivity.this, InfoActivity.class);
        startActivity(intent);
    }
    
    private void openSleepAnalysis() {
        Intent intent = new Intent(MainActivity.this, SleepAnalysis.class);
        startActivity(intent);
    }

    private void openToDO() {
        Intent intent = new Intent(MainActivity.this, ToDoList.class);
        startActivity(intent);
    }

    private void openEventCalendar() {
        Intent intent = new Intent(MainActivity.this, EventCalendar.class);
        startActivity(intent);
    }
}