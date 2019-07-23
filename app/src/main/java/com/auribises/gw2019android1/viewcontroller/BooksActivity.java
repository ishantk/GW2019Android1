package com.auribises.gw2019android1.viewcontroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

import com.auribises.gw2019android1.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class BooksActivity extends AppCompatActivity {

    StringBuilder builder;
    BooksTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        builder = new StringBuilder();

        task = new BooksTask();
        task.execute();

    }

    // If we need to any task in activity which will take more time, we need a thread
    // Threads in Android are called AsyncTask :)

    /*
    class BooksThread extends Thread{

        public void run() {

        }
    }
    */

    class BooksTask extends AsyncTask{ // Thread in Android :) Which will run Parallel to the Activity

        @Override
        protected Object doInBackground(Object[] objects) {

            // Our Code Should be written here, which should be executed in background
            // Whatever we writ in doInBackground should not be something associated with activity i.e. with UI
            // It means, no setText or getText on UI for example !!
            // We cannot use any UI component of Activity here :)

            try{

                // 1. Specify URL of the WebService
                //URL url = new URL("http://www.json-generator.com/api/json/get/chQLxhBjaW?indent=2");
                URL url = new URL("https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=");

                // 2. Send Request by making a connection to Web Service
                URLConnection connection = url.openConnection();

                // 3. Read Response from Web Service in InputStream
                InputStream inputStream = connection.getInputStream();

                // 4. Create BufferedReader to process response in String Format
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                String line = "";

                // Add Response line by line in StringBuilder
                while((line = reader.readLine()) != null){
                    builder.append(line);
                }

            }catch (Exception e){
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            Toast.makeText(getApplicationContext(), "Response:" + builder.toString(), Toast.LENGTH_LONG).show();
            Log.i("RESPONSE", builder.toString());
        }

        @Override
        protected void onPreExecute() {

        }
    }
}


// Please Refer if internet connection is not working in AVD
// https://stackoverflow.com/questions/42736038/android-emulator-not-able-to-access-the-internet