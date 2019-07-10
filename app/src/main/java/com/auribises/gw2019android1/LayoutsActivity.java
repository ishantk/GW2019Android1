package com.auribises.gw2019android1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class LayoutsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lRef;
    ArrayAdapter<String> adapter;


    void initViews(){

        lRef = findViewById(R.id.listView);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        adapter.add("Zee News"); // 0
        adapter.add("CNN");      // 1
        adapter.add("Aaj Tak");  // 2
        adapter.add("ABP");      // 3
        adapter.add("BBC");      // 4
        adapter.add("News18");   // 5

        lRef.setAdapter(adapter);
        lRef.setOnItemClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_layouts);
        //setContentView(R.layout.activity_linear);
        //setContentView(R.layout.activity_table);
        //setContentView(R.layout.activity_frame);

        setContentView(R.layout.activity_list);

        getSupportActionBar().setTitle("News");

        initViews(); // Execute it always in onCreate and after setContentView
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        if(position == 0){
            String url = "https://zeenews.india.com";
            Intent intent = new Intent(LayoutsActivity.this, NewsActivity.class);
            intent.putExtra("keyUrl", url);
            startActivity(intent);
        }
        switch (position){
            case 0:

                break;

            case 1:

                break;
        }

        //String news = adapter.getItem(position);
        //Toast.makeText(this, "You Clicked: "+position+" | "+news, Toast.LENGTH_LONG).show();
    }
}
