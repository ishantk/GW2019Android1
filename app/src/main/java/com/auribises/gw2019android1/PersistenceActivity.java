package com.auribises.gw2019android1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class PersistenceActivity extends AppCompatActivity {

    EditText eTxtData;
    Button btnSave;

    String data;

    // APIs to save data in XML file format in the form of key value pair !!
    SharedPreferences preferences;
    SharedPreferences.Editor editor;


    void initViews(){
        eTxtData = findViewById(R.id.editTextData);
        btnSave = findViewById(R.id.buttonSave);

        // SharedPreferences Represents XML File
        preferences = getSharedPreferences("appData", MODE_PRIVATE); // appData.xml
        // SharedPreferences.Editor is used to write/update data in xml file
        editor = preferences.edit();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = eTxtData.getText().toString();
                //saveDataInInternalFile();
                //saveDataInExternalFile();

                editor.putString("keyData",data);
                editor.putInt("salary",30000);
                editor.apply(); // Save the File
                Toast.makeText(getApplicationContext(), "Data Saved in SharedPreferences", Toast.LENGTH_LONG).show();
            }
        });

        // Read From Shared Preferences
        String fetchData = preferences.getString("keyData", "NA");
        int num = preferences.getInt("salary", 0);

        eTxtData.setText(fetchData+" | "+num);

        // Removing Data in SharedPreferences
        //editor.clear();
        //editor.apply();

        // Removing a specific key from SharedPreferences
        //editor.remove("keyData");
        //editor.apply();
    }

    void saveDataInInternalFile(){
        try {
            FileOutputStream outputStream = openFileOutput("data.txt", MODE_PRIVATE);
            outputStream.write(data.getBytes());
            outputStream.close();
            Toast.makeText(this, "Data Saved in File", Toast.LENGTH_LONG).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    void readDataFromInternalFile(){
        try {

            FileInputStream inputStream = openFileInput("data.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = reader.readLine();
            eTxtData.setText(line);
            getSupportActionBar().setTitle(line);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    void saveDataInExternalFile(){
        try {

            String path = Environment.getExternalStorageDirectory().getPath();
            File file = new File(path+"/data.txt");

            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(data.getBytes());
            outputStream.close();
            Toast.makeText(this, "Data Saved in File: "+file.getPath(), Toast.LENGTH_LONG).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    void readDataFromExternalFile(){
        try {

            String path = Environment.getExternalStorageDirectory().getPath();
            File file = new File(path+"/data.txt");

            FileInputStream inputStream = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = reader.readLine();
            eTxtData.setText(line);
            getSupportActionBar().setTitle(line);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persistence);
        initViews();
        //readDataFromInternalFile();
        readDataFromExternalFile();
    }
}

// Assignment : Use SharedPreferences and Create Login/Signup Modeule to HomeActivity
// 1st Time
// SplashActivity -> SignUpActivity (Details) -> HomeActivity
// 2nd Time
// SplashActivity -> HomeActivity

