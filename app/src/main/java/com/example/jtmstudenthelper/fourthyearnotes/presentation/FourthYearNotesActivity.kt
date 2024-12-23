package com.example.jtmstudenthelper.fourthyearnotes.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jtmstudenthelper.R
import com.example.jtmstudenthelper.booksData.domain.model.BooksData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FourthYearNotesActivity: AppCompatActivity() {

    private val viewModel : FourthYearViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fourth_year_notes_activity)

        viewModel.fourthyearbooks.observe(this) {BooksData->

            val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
            recyclerView.adapter = FourthYearDataAdapter(BooksData, this)
            recyclerView.layoutManager = GridLayoutManager(this, 1)
        }
    }


}