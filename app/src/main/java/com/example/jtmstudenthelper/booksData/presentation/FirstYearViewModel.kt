package com.example.jtmstudenthelper.booksData.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jtmstudenthelper.booksData.domain.model.BooksDataModel
import com.example.jtmstudenthelper.data.repositorise.BooksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirstYearViewModel @Inject constructor(private val repository: BooksRepository) :
    ViewModel() {

    val firstYearBooks: LiveData<List<BooksDataModel>> = repository.getFirstYearBooks()



}