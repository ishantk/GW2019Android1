package com.auribises.gw2019android1;

import androidx.annotation.Nullable;
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

        //String name = eTxtName.getText().toString();
       // String phone = eTxtPhone.getText().toString();

        //int number = Integer.parseInt(eTxtPhone.getText().toString());

        // We have created Intent for ActivityTwo
        //Intent intent = new Intent(ActivityOne.this, ActivityTwo.class);

        // Forward Passing the Data
        // 1. Passing Data Directly in Intent
        // Put Data in Intent : To pass data from ActivityOne to ActivityTwo
        // intent.putExtra("keyName", name);
        // intent.putExtra("keyPhone", phone);

        // intent.putExtra("keyNumber", number);

        // 2. Pass Data in Bundle Object

        /*
        Bundle bundle = new Bundle();
        bundle.putString("keyName", name);
        bundle.putString("keyPhone", phone);
        bundle.putInt("keyAge", 30);

        intent.putExtra("keyBundle", bundle);
        */

        // 3. Pass Data in User Defined Object

        // Object Construction Statement
        /*Person person = new Person();
        person.name = eTxtName.getText().toString();
        person.phone = eTxtPhone.getText().toString();
        person.age = 22;

        Intent intent = new Intent(ActivityOne.this, ActivityTwo.class);
        intent.putExtra(Util.KEY_PERSON, person);

        startActivity(intent);
        */

        Intent intent = new Intent(ActivityOne.this, ActivityTwo.class);
        startActivityForResult(intent, 101);
    }


    //onActivityResult will be executed automatically when ActivityTwo will execute setResult and finish itself
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode == 101 && resultCode == 201){
            String name = data.getStringExtra("keyName");
            String phone = data.getStringExtra("keyPhone");

            eTxtName.setText(name);
            eTxtPhone.setText(phone);
        }

    }
}

// Assignment:
// In ActivtyOne take input in EditText from user which will be an integer number
// Start ActivityTwo. In ActivityTwo create TextView and show table of that number on TextView