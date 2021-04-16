package com.groupproject.silva;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.SettingInjectorService;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

import java.util.Calendar;

public class SleepAnalysis extends AppCompatActivity {
    Button button_pop_up;
    Dialog infoDialog;
    ImageView Closepopup;
    TimePickerDialog selection;
    EditText SetTime,SetAlarm;
    Button b1;
    int Chour,Cmin;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_analysis);
        Variable();
        onClick();
    }
    
    private void Variable() {
        infoDialog = new Dialog(SleepAnalysis.this);
        infoDialog.setContentView(R.layout.activity_pop_up_sleep);
        infoDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        infoDialog.getWindow().getAttributes().windowAnimations = R.style.animation;
        
        button_pop_up = (Button) findViewById(R.id.rec_info);
        Closepopup = infoDialog.findViewById(R.id.close_popup);
        
        b1 = (Button)findViewById(R.id.rec_ime_1);
        
        SetAlarm = (EditText) findViewById(R.id.setalarm);
        SetTime = (EditText) findViewById(R.id.time_dialog);
        SetTime.setInputType(InputType.TYPE_NULL);
        SetAlarm.setInputType(InputType.TYPE_NULL);
    }
    
    public void onClick(){
        SetTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingT();
            }
        });
        SetAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingA();
            }
        });
        button_pop_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoDialog.show();
            }
        });
        Closepopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoDialog.dismiss();
            }
        });
    }
    
    private void SettingA() {
        Calendar calendar = Calendar.getInstance();
        Chour = calendar.get(Calendar.HOUR_OF_DAY);
        Cmin = calendar.get(Calendar.MINUTE);
        selection = new TimePickerDialog(SleepAnalysis.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                SetTime.setText(String.format("%d:%d", hourOfDay, minute));
            }
        },Chour,Cmin,true);
        selection.show();
    }
    
    private void SettingT() {
        Calendar calendar = Calendar.getInstance();
        Chour = calendar.get(Calendar.HOUR_OF_DAY);
        Cmin = calendar.get(Calendar.MINUTE);
        selection = new TimePickerDialog(SleepAnalysis.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                SetTime.setText(String.format("%d:%d", hourOfDay, minute));
                if((hourOfDay + 8) >= 24){
                    hourOfDay = hourOfDay - 24 + 8;
                    SetAlarm.setText(String.format("%d:%d", hourOfDay, minute));
                }else if ((hourOfDay + 8) <= 23){
                    SetAlarm.setText(String.format("%d:%d",hourOfDay+8,minute));
                }
            }
        },Chour,Cmin,true);
        selection.show();
    }
}