package com.auribises.gw2019android1;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SensorsActivity extends AppCompatActivity implements SensorEventListener {

    TextView txtData;
    Button btnShake;

    SensorManager sensorManager;
    Sensor sensor;

    void initViews(){
        txtData = findViewById(R.id.textViewData);
        btnShake = findViewById(R.id.buttonShake);

        // Get Reference to SensorManager
        // SensorManager is a Service in Android which ic running in the background
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        // Get the Sensor which you want to monitor
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        btnShake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sensorManager.registerListener(SensorsActivity.this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors);
        initViews();
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        float[] values = sensorEvent.values;

        float x = values[0];
        float y = values[1];
        float z = values[2];

        float result = (x*x)+(y*y)+(z*z)/SensorManager.GRAVITY_EARTH*SensorManager.GRAVITY_EARTH;

        if(result>3){
            txtData.setText("Device Shaken"+result);
        }else{
            txtData.setText(x+" | "+y+" | "+z);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sensorManager.unregisterListener(this);
    }
}
