package com.example.jtmstudenthelper.fourthyearnotes.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.jtmstudenthelper.booksData.domain.model.BooksData
import com.example.jtmstudenthelper.data.repositorise.BooksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FourthYearViewModel @Inject constructor(private val repository: BooksRepository) :
    ViewModel() {

    val fourthyearbooks: LiveData<List<BooksData>> = repository.getFourthYearBooks()
}