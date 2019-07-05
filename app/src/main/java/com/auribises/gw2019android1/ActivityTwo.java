package com.auribises.gw2019android1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ActivityTwo extends AppCompatActivity {

    // References to Views
    EditText eTxtName, eTxtPhone;

    void initViews(){
        eTxtName = findViewById(R.id.editTextName);
        eTxtPhone = findViewById(R.id.editTextPhone);

        // Receiving Intent from ActivityOne
        Intent rcv = getIntent();

        // Fetch Data from Intent
        String name = rcv.getStringExtra("keyName");
        String phone = rcv.getStringExtra("keyPhone");
        int number = rcv.getIntExtra("keyNumber", 0);

        // Set Data on UI i.e. Activity
        eTxtName.setText(name);
        eTxtPhone.setText(phone);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        getSupportActionBar().setTitle("Activity Two");

        initViews();
    }

    public void clickHandler(View view){
       finish();
    }
}
