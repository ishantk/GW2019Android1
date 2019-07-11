package com.auribises.gw2019android1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
                                                            // 1. Handled By our OWN Class
public class ClickListenerActivity extends AppCompatActivity implements View.OnClickListener {

    // References to Views
    TextView txtTitle;
    Button btnSubmit;

    void initViews(){
        txtTitle = findViewById(R.id.textViewTitle);
        btnSubmit = findViewById(R.id.buttonSubmit);

        //btnSubmit.setOnClickListener(this);

        //2. Nested Class - User Defined
        //MyClickListener ref = new MyClickListener();
        //btnSubmit.setOnClickListener(ref);

        //3. Anonymous Class
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YY | hh:mm:ss");

                String dateTimeStamp = sdf.format(date);

                txtTitle.setText(dateTimeStamp);
                getSupportActionBar().setTitle(date.toString());
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_listener);
        initViews();
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.buttonSubmit){

            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YY | hh:mm:ss");

            String dateTimeStamp = sdf.format(date);

            txtTitle.setText(dateTimeStamp);
            getSupportActionBar().setTitle(date.toString());

        }
    }

    // Nested Class - User Defined
    class MyClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            if(view.getId() == R.id.buttonSubmit){

                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YY | hh:mm:ss");

                String dateTimeStamp = sdf.format(date);

                txtTitle.setText(dateTimeStamp);
                getSupportActionBar().setTitle(date.toString());

            }
        }
    }

}
