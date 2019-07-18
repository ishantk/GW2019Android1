package com.auribises.gw2019android1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;

public class AllMusicActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    ArrayAdapter<String> adapter;

    void initViews(){
        listView = findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

        // Get the Path to SD Card
        //String path = Environment.getExternalStorageDirectory().getPath();
        //Log.i("AllMusicActivity", path);

        String path = "/storage";

        //File file = new File(path);
        File file = new File(path);
        String[] fileNames = file.list(); // This will give us names of all the files in SD Card

        if(fileNames != null){
            for(String name : fileNames){
                if(name.endsWith(".mp3")) {
                    adapter.add(name);
                }
            }
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(this);
        }else{
            Toast.makeText(this, "No Files Found", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_music);

        initViews();

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        String songName = adapter.getItem(i);
        Toast.makeText(this, "You Selected:"+songName, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(AllMusicActivity.this, PlayMusicActivity.class);
        intent.putExtra("keySong", songName);
        startActivity(intent);

    }
}
