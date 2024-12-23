package com.example.jtmstudenthelper

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.jtmstudenthelper.booksData.presentation.FirstYearBooksDataActivity
import com.example.jtmstudenthelper.booksData.presentation.SecondYearBooksDataActivity
import com.example.jtmstudenthelper.fourthyearnotes.presentation.FourthYearNotesActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ClassesAboutNotes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.classes_about_notes)

        val backbutton = findViewById<ImageView>(R.id.backbutton)
        backbutton.setOnClickListener {
            onBackPressed()
        }

        val firstyeartxt = findViewById<TextView>(R.id.firstYearTextView)
        firstyeartxt.setOnClickListener {
            val intent = Intent(this, FirstYearBooksDataActivity::class.java)
            startActivity(intent)
        }

        val secondyeartxt = findViewById<TextView>(R.id.SecondYearTextView)
        secondyeartxt.setOnClickListener {
            val intent = Intent(this ,SecondYearBooksDataActivity::class.java)
            startActivity(intent)
        }

        val fourthyeartxt = findViewById<TextView>(R.id.fourthyeartextview)
        fourthyeartxt.setOnClickListener {
            val intent = Intent(this, FourthYearNotesActivity::class.java)
            startActivity(intent)
        }



    }
}
