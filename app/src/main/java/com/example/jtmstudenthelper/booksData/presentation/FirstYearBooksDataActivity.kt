package com.example.jtmstudenthelper.booksData.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jtmstudenthelper.R
import com.example.jtmstudenthelper.booksData.domain.model.BooksDataModel
import dagger.hilt.android.AndroidEntryPoint
import io.appwrite.Client

@AndroidEntryPoint
class FirstYearBooksDataActivity : AppCompatActivity() {




    private val viewModel: FirstYearViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_year_books_data)

       viewModel.firstYearBooks.observe(this) {BooksDataModel->

           val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
           recyclerView.adapter = FirstYearAdapter(BooksDataModel,this)
           recyclerView.layoutManager = GridLayoutManager(this, 2)
       }



    }


}