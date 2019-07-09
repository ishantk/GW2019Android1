package com.auribises.gw2019android1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();

        handler.sendEmptyMessageDelayed(111, 2500);

    }

    Handler handler = new Handler(){

        @Override
        public void handleMessage(@NonNull Message msg) {
            if(msg.what == 111){
                Intent intent = new Intent(SplashActivity.this, ActivityOne.class);
                startActivity(intent);
                finish();
            }
        }
    };

}
