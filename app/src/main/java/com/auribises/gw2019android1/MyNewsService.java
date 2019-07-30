package com.auribises.gw2019android1;

import android.app.IntentService;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class MyNewsService extends IntentService {

    public MyNewsService() {
        super("MyNewsService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i("MyNewsService", "==onHandleIntent==");

        StringBuilder builder;

        try{

            URL url = new URL(intent.getStringExtra("keyUrl"));

            URLConnection connection = url.openConnection();

            InputStream inputStream = connection.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line = "";

            builder = new StringBuilder();

            while((line = reader.readLine()) !=null){
                builder.append(line);
            }

            // Logging the response in builder on Logcat
            Log.i("MyNewsService", builder.toString());


            Intent sendNews = new Intent("com.auribises.gw2019android1.newsresponse");
            sendNews.putExtra("keyResponse", builder.toString());
            LocalBroadcastManager.getInstance(this).sendBroadcast(sendNews);

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
