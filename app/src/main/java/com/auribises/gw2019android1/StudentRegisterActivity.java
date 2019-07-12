package com.auribises.gw2019android1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

public class StudentRegisterActivity extends AppCompatActivity implements View.OnClickListener {


    // References to Views
    EditText eTxtName, eTxtPhone, eTxtEmail;
    RadioButton rbMale, rbFemale;

    Spinner spinnerCity;
    ArrayAdapter<String> adapter;

    Button btnSubmit;
    RatingBar ratingBar;

    Student sRef;

    // Initialize References to Views of Activity
    void initViews(){
        eTxtName = findViewById(R.id.editTextName);
        eTxtPhone = findViewById(R.id.editTextPhone);
        eTxtEmail = findViewById(R.id.editTextEmail);

        rbMale = findViewById(R.id.radioButtonMale);
        rbFemale = findViewById(R.id.radioButtonFemale);

        spinnerCity = findViewById(R.id.spinnerCity);

        btnSubmit = findViewById(R.id.buttonRegister);

        ratingBar = findViewById(R.id.ratingBar);

        sRef = new Student();

        btnSubmit.setOnClickListener(this);
        rbMale.setOnClickListener(this);
        rbFemale.setOnClickListener(this);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item);
        adapter.add("==Select City=="); //0
        adapter.add("Ludhiana"); //1
        adapter.add("Delhi"); //2
        adapter.add("Chandigarh"); //3
        adapter.add("Bangalore"); //4

        spinnerCity.setAdapter(adapter);

        spinnerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                sRef.city = adapter.getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                sRef.rating = v;
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_register);
        initViews();
    }

    @Override
    public void onClick(View view) {

        int id = view.getId();



        if(id == R.id.buttonRegister){

            sRef.name = eTxtName.getText().toString();
            sRef.phone = eTxtPhone.getText().toString();
            sRef.email = eTxtEmail.getText().toString();

            Toast.makeText(this, sRef.toString() ,Toast.LENGTH_LONG).show();

            Intent intent = new Intent(StudentRegisterActivity.this, ConfirmStudentDetailsActivity.class);
            intent.putExtra("keyStudent", sRef);
            startActivity(intent);

        }else if( id == R.id.radioButtonMale){

            sRef.gender = 'M';

        }else if( id == R.id.radioButtonFemale){
            sRef.gender = 'F';
        }


    }
}
