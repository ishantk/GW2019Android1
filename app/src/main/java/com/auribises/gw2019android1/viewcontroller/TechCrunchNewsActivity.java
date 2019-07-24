package com.auribises.gw2019android1.viewcontroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.auribises.gw2019android1.R;
import com.auribises.gw2019android1.model.TechCrunchNews;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class TechCrunchNewsActivity extends AppCompatActivity {

    StringBuilder builder;
    FetchNewsTask task;

    ArrayList<TechCrunchNews> newsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech_crunch_news);

        task = new FetchNewsTask();
        task.execute();
    }

    // 1. Fetch JSON data from Web Service
    // Nested Class
    class FetchNewsTask extends AsyncTask{

        @Override
        protected Object doInBackground(Object[] objects) {

            try{

                URL url = new URL("https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=31c21508fad64116acd229c10ac11e84");

                URLConnection connection = url.openConnection();

                InputStream inputStream = connection.getInputStream();

                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                String line = "";

                builder = new StringBuilder();

                while((line = reader.readLine()) !=null){
                    builder.append(line);
                }

                // We now need to display the data in Toast or Log

            }catch (Exception e){
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            Toast.makeText(getApplicationContext(), "Response:"+builder.toString(), Toast.LENGTH_LONG).show();
            Log.i("TechCrunchNewsActivity", builder.toString());

            parseJSONResponse();
        }
    }

    // 2. Extract meaningful or required data from JSON Data
    void parseJSONResponse(){

        try{

            // Create JSON Object from JSON Response
            JSONObject jObj = new JSONObject(builder.toString());
            JSONArray array = jObj.getJSONArray("articles");

            newsList = new ArrayList<>();

            for(int i=0; i<array.length();i++){
                JSONObject obj = array.getJSONObject(i);

                /*String author = obj.getString("author");
                String title = obj.getString("title");
                String urlToImage = obj.getString("urlToImage");
                String publishedAt = obj.getString("publishedAt");*/

                // 3. Meaningful data from JSON Data is represented as an Object in Java
                TechCrunchNews news = new TechCrunchNews();

                news.author = obj.getString("author");
                news.title = obj.getString("title");
                news.urlToImage = obj.getString("urlToImage");
                news.publishedAt = obj.getString("publishedAt");

                newsList.add(news);

                Log.i("TechCrunchNewsActivity", news.toString());
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
