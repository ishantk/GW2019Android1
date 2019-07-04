package com.auribises.gw2019android1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

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


    public void clickHandler(View view){
        Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show();

        // To navigate from 1 activity to other activity

        // Explicit Way
                                    // source to destination
        // Intent intent = new Intent(MainActivity.this, HomeActivity.class);

        // Implicit Way
        Intent intent = new Intent("com.auribises.gw2019android1.homeactivity");
        startActivity(intent);
    }


    // Assignment : Create 5 Activities and on different menu clicks open different activities


    // Helps to Create Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        /*
        // Explicit Menu Creation
        //      groupid, itemid, order, title
        menu.add(1, 101, 1, "All Music");

        // We can make a menu item as an action item
        menu.add(1, 222, 1, "Artists").setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

        menu.add(1, 301, 1, "PlayLists");
        menu.add(2, 401, 1, "Favourites");
        menu.add(2, 501, 1, "Recently Played");
        */

        // Implicit Menu Creation
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);

        return super.onCreateOptionsMenu(menu);
    }

    // Helps to know which menu we selected
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        /*
        if(id == 101){
            Toast.makeText(this, "You Selected All Music", Toast.LENGTH_SHORT).show();
        }else if(id == 201){
            Toast.makeText(this, "You Selected Artists", Toast.LENGTH_SHORT).show();
        }*/

        /*
        switch (id){
            case 101:
                Toast.makeText(this, "You Selected All Music", Toast.LENGTH_SHORT).show();
                break;

            case 222:
                Toast.makeText(this, "You Selected Artists", Toast.LENGTH_SHORT).show();
                break;
        }
        */

        switch (id) {
            case R.id.admin:
                Toast.makeText(this, "You Selected Admin", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);

                break;

            case R.id.hr:
                Toast.makeText(this, "You Selected HR", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
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