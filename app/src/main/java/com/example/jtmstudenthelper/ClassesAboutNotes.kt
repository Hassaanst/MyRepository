package com.example.jtmstudenthelper

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.jtmstudenthelper.eighthYearNotes.presentation.EightYearNotesActivity
import com.example.jtmstudenthelper.fifthYearNotes.presentation.FifthYearNotesActivity
import com.example.jtmstudenthelper.firstYearNotes.presentation.FirstYearNotesActivity
import com.example.jtmstudenthelper.notes.presentation.NotesActivity
import com.example.jtmstudenthelper.secondYearNotes.presentation.SecondYearNotesActivity
import com.example.jtmstudenthelper.seventhYearNotes.presentation.SeventhYearNotesActivity
import com.example.jtmstudenthelper.sixthYearNotes.presentation.SixthYearNotesActivity
import com.example.jtmstudenthelper.thirdYearNotes.presentation.ThirdYearNotesActivity
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
            val intent = Intent(this, FirstYearNotesActivity::class.java)
            startActivity(intent)
        }

        val seconyeartxt = findViewById<TextView>(R.id.SecondYearTextView)
        seconyeartxt.setOnClickListener {
            val intent = Intent(this, SecondYearNotesActivity::class.java)
            startActivity(intent)
        }

        val thirdyeartxt = findViewById<TextView>(R.id.thirdyeartxt)
        thirdyeartxt.setOnClickListener {
            val intent = Intent(this, ThirdYearNotesActivity::class.java)
            startActivity(intent)
        }


        val fourthyeartxt = findViewById<TextView>(R.id.fourthyeartextview)
        fourthyeartxt.setOnClickListener {
            val intent = Intent(this, NotesActivity::class.java)
            startActivity(intent)
        }

        val fifthyeartxt = findViewById<TextView>(R.id.fifthyeartxt)
        fifthyeartxt.setOnClickListener {
            val intent = Intent(this, FifthYearNotesActivity::class.java)
            startActivity(intent)
        }

        val sixthyeartxt = findViewById<TextView>(R.id.sixthyeartxt)
        sixthyeartxt.setOnClickListener {
            val intent = Intent(this, SixthYearNotesActivity::class.java)
            startActivity(intent)
        }

        val seventhyeartxt = findViewById<TextView>(R.id.seventhyeartxt)
        seventhyeartxt.setOnClickListener {
            val intent = Intent(this, SeventhYearNotesActivity::class.java)
            startActivity(intent)
        }


        val eighthyeartxt = findViewById<TextView>(R.id.eighthyeartxt)
        eighthyeartxt.setOnClickListener {
            val intent = Intent(this, EightYearNotesActivity::class.java)
            startActivity(intent)
        }



    }
}
