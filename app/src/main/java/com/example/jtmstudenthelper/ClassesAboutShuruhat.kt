package com.example.jtmstudenthelper

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ClassesAboutShuruhat: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.classes_about_shuruhat)


        val backbutton = findViewById<ImageView>(R.id.backbutton)
        backbutton.setOnClickListener {
            onBackPressed()
        }
    }
}