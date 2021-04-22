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
import android.os.CountDownTimer;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SleepAnalysis extends AppCompatActivity {
    Dialog infoDialog;
    ImageView Closepopup;
    TextView ShowCurrentTime, Rec_time,SetTimer;
    ImageView ShowCurrentTimeImg;
    Button button_pop_up,STimer,RTimer;
    int Chour, Cmin;
    
    long Timeleft = 25 * 60000;//60000 is 1 minutes
    long TDuration = Timeleft;
    boolean RunningTime;
    CountDownTimer countDownTimer;
    
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
        ShowCurrentTimeImg = (ImageView) findViewById(R.id.Set_time);
        
        SetTimer = (TextView) findViewById(R.id.setalarm);
        SetTimer.setInputType(InputType.TYPE_NULL);
        STimer = (Button) findViewById(R.id.rec_ime_1);
        RTimer = (Button) findViewById(R.id.rec_ime_3);
        
        Rec_time = (TextView) findViewById(R.id.rec_time);
        ShowCurrentTime = (TextView) findViewById(R.id.time_dialog);
        
    }
    
    public void onClick() {
        STimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartStop();
            }
        });
        RTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RestTimer();
            }
        });
        ShowCurrentTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingT();
            }
        });
        ShowCurrentTimeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingT();
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
        updateText();
    }
    
    private void RestTimer() {
        Timeleft = TDuration;
        updateText();
        RTimer.setVisibility(View.INVISIBLE);
        STimer.setVisibility(View.VISIBLE);
    }
    
    private void StartStop() {
        if(RunningTime){
            PTimer();
        }else {
            StartTimer();
        }
    }
    
    private void StartTimer() {
        countDownTimer = new CountDownTimer(Timeleft,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Timeleft = millisUntilFinished;
                updateText();
            }
            
            @Override
            public void onFinish() {
                RunningTime = false;
                STimer.setText("Start");
                STimer.setVisibility(View.INVISIBLE);
                RTimer.setVisibility(View.VISIBLE);
            }
        }.start();
        STimer.setText("Pause");
        RTimer.setVisibility(View.INVISIBLE);
        RunningTime = true;
    }
    
    private void updateText() {
        int Tmin = (int) (Timeleft/1000) / 60;
        int Tsec = (int) (Timeleft/1000) % 60;
        
        String TextTimer = String.format(Locale.getDefault(), "%02d:%02d", Tmin, Tsec);
        SetTimer.setText(TextTimer);
    }
    
    private void PTimer() {
        countDownTimer.cancel();
        RunningTime = false;
        STimer.setText("Start");
        RTimer.setVisibility(View.VISIBLE);
    }
    /*
    
    
    private void SettingA() {
        Calendar calendar = Calendar.getInstance();
        Chour = calendar.get(Calendar.HOUR_OF_DAY);
        Cmin = calendar.get(Calendar.MINUTE);
        TimePickerDialog selection = new TimePickerDialog(SleepAnalysis.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Rec_time.setText(String.format("%d:%d", hourOfDay, minute));
            }
        }, Chour, Cmin, true);
        selection.show();
    }*/
    
    private void SettingT() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        ShowCurrentTime.setText(timeFormat.format(calendar.getTime()));
        Chour = calendar.get(Calendar.HOUR_OF_DAY);
        Cmin = calendar.get(Calendar.MINUTE);
        if ((Chour + 8) >= 24) {
            Chour = Chour - 24 + 8;
            Rec_time.setText(String.format("%d:%d", Chour, Cmin));
        } else if ((Chour + 8) <= 23) {
            Rec_time.setText(String.format("%d:%d", Chour + 8, Cmin));
        }
    }
}