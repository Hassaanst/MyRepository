package com.example.jtmstudenthelper.booksData.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jtmstudenthelper.R
import com.example.jtmstudenthelper.booksData.domain.model.BooksDataModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondYearBooksDataActivity : AppCompatActivity() {

    private val viewModel: SecondYearViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_year_book_data_activity)

        viewModel.secondYearBooks.observe(this) { BooksDataModel ->

            val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
            recyclerView.adapter = SecondYearAdapter(BooksDataModel, this)
            recyclerView.layoutManager = GridLayoutManager(this, 2)

        }

    }
}