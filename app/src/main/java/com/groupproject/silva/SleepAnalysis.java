package com.groupproject.silva;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.SettingInjectorService;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SleepAnalysis extends AppCompatActivity {
    Button button_pop_up;
    Dialog infoDialog, SelectTimeDialog;
    ImageView Closepopup, SetTimeImg, ClosepopupRec;
    TextView SetTimeText;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_analysis);
        infoDialog = new Dialog(SleepAnalysis.this);
        infoDialog.setContentView(R.layout.activity_pop_up_sleep);
        infoDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        infoDialog.getWindow().getAttributes().windowAnimations = R.style.animation;
        
        SelectTimeDialog = new Dialog(SleepAnalysis.this);
        SelectTimeDialog.setContentView(R.layout.activity_pop_up_setrectime);
        SelectTimeDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        SelectTimeDialog.getWindow().getAttributes().windowAnimations = R.style.animation;
        
        button_pop_up = (Button) findViewById(R.id.rec_info);
        Closepopup = infoDialog.findViewById(R.id.close_popup);
        ClosepopupRec = SelectTimeDialog.findViewById(R.id.close_popup);
        SetTimeText = (TextView) findViewById(R.id.time_dialog);
        SetTimeImg = (ImageView) findViewById(R.id.Set_time);
        
        SetTimeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectTimeDialog.show();
            }
        });
        
        SetTimeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectTimeDialog.show();
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
        ClosepopupRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectTimeDialog.dismiss();
            }
        });
    }
    
    
}