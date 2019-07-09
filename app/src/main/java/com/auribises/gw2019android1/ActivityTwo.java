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

        /*
        // Fetch Data from Intent
        String name = rcv.getStringExtra("keyName");
        String phone = rcv.getStringExtra("keyPhone");
        int number = rcv.getIntExtra("keyNumber", 0);

        */

        /*
        Bundle rcvbundle = rcv.getBundleExtra("keyBundle");
        String name = rcvbundle.getString("keyName");
        String phone = rcvbundle.getString("keyPhone");
        int age = rcvbundle.getInt("keyAge");

        // Set Data on UI i.e. Activity
        eTxtName.setText(name+" | "+age);
        eTxtPhone.setText(phone);
        */

        /*Person person = (Person)rcv.getSerializableExtra(Util.KEY_PERSON);
        eTxtName.setText(person.name+" | "+person.age);
        eTxtPhone.setText(person.phone);
        */
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        getSupportActionBar().setTitle("Activity Two");

        initViews();
    }

    public void clickHandler(View view){

        // Fetch Data from User in ActivtyTwo
        String name = eTxtName.getText().toString();
        String phone = eTxtPhone.getText().toString();

        // Put Data in an Empty Intent
        Intent data = new Intent();

        data.putExtra("keyName", name);
        data.putExtra("keyPhone", phone);

        setResult(201, data);

        finish();
    }
}
