package com.example.jtmstudenthelper.booksData.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.jtmstudenthelper.booksData.domain.model.BooksDataModel
import com.example.jtmstudenthelper.data.repositorise.BooksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SecondYearViewModel @Inject constructor(private val repository: BooksRepository) :
    ViewModel() {

        val secondYearBooks: LiveData<List<BooksDataModel>> = repository.getSecondYearBooks()


}