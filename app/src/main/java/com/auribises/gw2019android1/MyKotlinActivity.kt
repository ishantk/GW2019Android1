package com.auribises.gw2019android1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.auribises.gw2019android1.viewcontroller.TechCrunchNewsActivity

class MyKotlinActivity : AppCompatActivity() {

    fun initViews(){

        val btn : Button = findViewById(R.id.button)
        btn.setOnClickListener{
            val intent : Intent = Intent(applicationContext, TechCrunchNewsActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_kotlin)
        initViews()
    }
}

// https://kotlinlang.org/docs/tutorials/
