package com.groupproject.silva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    private TextView text1;
    private TextView text2;
    private ImageView image1;
    private static int SPlASH_SCREEN = 3500;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        text1 = (TextView) findViewById(R.id.text1);
        image1 = (ImageView) findViewById(R.id.image1);
        text2 = (TextView) findViewById(R.id.text2);

        Animation anim = AnimationUtils.loadAnimation(this,R.anim.transition);
        Animation anim2 = AnimationUtils.loadAnimation(this,R.anim.transition2);

        text1.startAnimation(anim);
        image1.startAnimation(anim);
        text2.startAnimation(anim2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPlASH_SCREEN);
    }
}