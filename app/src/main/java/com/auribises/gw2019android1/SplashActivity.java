package com.auribises.gw2019android1;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;


import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Space;


import com.auribises.gw2019android1.viewcontroller.AddCustomerActivity;
import com.auribises.gw2019android1.viewcontroller.TechCrunchNewsActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();


        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if(firebaseUser!=null) {
            handler.sendEmptyMessageDelayed(111, 2500);
        }else{
            handler.sendEmptyMessageDelayed(222, 2500);
        }

    }

    Handler handler = new Handler(){

        @Override
        public void handleMessage(@NonNull Message msg) {
            if(msg.what == 111){
                Intent intent = new Intent(SplashActivity.this, AddCustomerActivity.class);
                startActivity(intent);
                finish();
            }else{
                Intent intent = new Intent(SplashActivity.this, RegisterUserActivity.class);
                startActivity(intent);
                finish();
            }
        }
    };


}

// For Google Libraries :)
// https://developers.google.com/android/guides/setup

// For Google Firebase Documentation
// https://firebase.google.com/docs/auth/