package com.example.jtmstudenthelper

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ClassesAboutFinalPapers: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.classes_about_final_papers)


        val backbutton = findViewById<ImageView>(R.id.backbutton)
        backbutton.setOnClickListener {
            onBackPressed()
        }
    }
}