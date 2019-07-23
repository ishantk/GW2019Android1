package com.auribises.gw2019android1;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.auribises.gw2019android1.ui.main.SectionsPagerAdapter;

public class MyTabbedActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabs;
    FloatingActionButton fab;
    SectionsPagerAdapter sectionsPagerAdapter;

    void initViews(){
        viewPager = findViewById(R.id.view_pager);
        tabs = findViewById(R.id.tabs);
        fab = findViewById(R.id.fab);

        sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());

        viewPager.setAdapter(sectionsPagerAdapter);

        tabs.setupWithViewPager(viewPager); // TabLayout is in Sync with ViewPager

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "You Clicked FAB Button", Snackbar.LENGTH_LONG).show();
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tabbed);

        initViews();

    }
}