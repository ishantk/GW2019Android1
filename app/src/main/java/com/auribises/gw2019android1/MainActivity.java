package com.auribises.gw2019android1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

// MainActivity IS AN AppCompatActivity | Inheritance
public class MainActivity extends AppCompatActivity {

    public final String TAG = "MainActivity";

    // When object of activity is created by Android System
    @Override
    protected void onCreate(Bundle savedInstanceState) {    // Overriding
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Linking the Layout of Activity

        Log.i(TAG, "onCreate");

    }

    // When object of activity is pushed into stack
    // Stack : BackStack or Task
    @Override
    protected void onStart() {
        super.onStart();

        Log.i(TAG, "onStart");
    }

    // When object of activity is visible as a rectangular screen
    @Override
    protected void onResume() {
        super.onResume();

        Log.i(TAG, "onResume");
    }

    // When your Activity is partially covered by some other UI Element or Activity
    @Override
    protected void onPause() {
        super.onPause();

        Log.i(TAG, "onPause");
    }

    // When user will press back button or programmer executes finish() function
    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i(TAG, "onDestroy");
    }


    // When Your Activity is full covered by some other UI Element ot Activity
    @Override
    protected void onStop() {
        super.onStop();

        Log.i(TAG, "onStop");
    }

}

// Activity Life Cycle :)
// Sequence : Create > Start > Resume > Pause > Stop > Destroy
// USE CASES:
// User clicks on App Icon and launches A1
// A1: Cr St Re
// From A1 User launches another A2
// A1: Pa St
// A2: Cr St Re
// In A2 user presses the back key
// A1: St Re
// A2: Pa St De