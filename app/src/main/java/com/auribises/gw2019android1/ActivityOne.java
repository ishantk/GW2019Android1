package com.auribises.gw2019android1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

// Rules for Activty Creation
// 1. Create an Activity
// 2. Check if it is in Manifest or not !!
// 3. Design Layout of Activity in XML File
//    In Design we drag and drop views (eg: Button, EditText, TextView etc...)
//    For Every View which we drag and drop change its id as per your terminology
// 4. Initialize views which you want to use in Java File using findViewById method

public class ActivityOne extends AppCompatActivity {

    // References to Views
    EditText eTxtName, eTxtPhone;

    void initViews(){
        eTxtName = findViewById(R.id.editTextName);
        eTxtPhone = findViewById(R.id.editTextPhone);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        getSupportActionBar().setTitle("Activity One");

        // Object Construction : Indirectly
        //eTxtName = findViewById(R.id.editTextName);
        //eTxtPhone = findViewById(R.id.editTextPhone);

        initViews();

    }

    public void clickHandler(View view){

        // Always, data which we will fetch from UI or we wish to set on UI will be String

        String name = eTxtName.getText().toString();
        String phone = eTxtPhone.getText().toString();

        //int number = Integer.parseInt(eTxtPhone.getText().toString());

        // We have created Intent for ActivityTwo
        Intent intent = new Intent(ActivityOne.this, ActivityTwo.class);

        // Forward Passing the Data
        // Put Data in Intent : To pass data from ActivityOne to ActivityTwo
        intent.putExtra("keyName", name);
        intent.putExtra("keyPhone", phone);

        //intent.putExtra("keyNumber", number);

        startActivity(intent);
    }
}

// Assignment:
// In ActivtyOne take input in EditText from user which will be an integer number
// Start ActivityTwo. In ActivityTwo create TextView and show table of that number on TextView