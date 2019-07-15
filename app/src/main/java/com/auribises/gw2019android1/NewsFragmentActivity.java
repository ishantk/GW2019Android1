package com.auribises.gw2019android1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class NewsFragmentActivity extends AppCompatActivity {

    // Create Reference to Fragments
    UpperFragment upperFragment;
    LowerFragment lowerFragment;

    void initViews(){
        // object construction statements for Fragments
        // For Activity, Object will be created by Android System and for Fragment we need to create !!
        upperFragment = new UpperFragment();
        lowerFragment = new LowerFragment();

        upperFragment.setMyListener(lowerFragment);

        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.upperFrame, upperFragment).commit();
        manager.beginTransaction().add(R.id.lowerFrame, lowerFragment).commit();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_fragment);
        initViews();
    }
}
