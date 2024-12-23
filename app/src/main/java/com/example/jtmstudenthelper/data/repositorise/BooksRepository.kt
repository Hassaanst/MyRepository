package com.example.jtmstudenthelper.data.repositorise

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.jtmstudenthelper.booksData.domain.model.BooksData
import com.example.jtmstudenthelper.booksData.domain.model.BooksDataModel
import com.google.firebase.database.FirebaseDatabase
import javax.inject.Inject

class BooksRepository @Inject constructor() {

    private val database = FirebaseDatabase.getInstance().getReference("BooksImages")

    fun getFirstYearBooks(): LiveData<List<BooksDataModel>> {
        val liveData = MutableLiveData<List<BooksDataModel>>()
        database.child("FirstYearBooksImages").get()
            .addOnSuccessListener { snapshot ->

                val books = snapshot.children.mapNotNull { it.getValue(BooksDataModel::class.java) }
                liveData.postValue(books)
            }
            .addOnFailureListener {
                liveData.postValue(emptyList()) // Handle errors
            }
        return liveData


    }


    fun getSecondYearBooks(): LiveData<List<BooksDataModel>> {

        val liveData = MutableLiveData<List<BooksDataModel>>()
        database.child("SecondYearBooksImages").get()

            .addOnSuccessListener { snapshot ->

                val books = snapshot.children.mapNotNull { it.getValue(BooksDataModel::class.java) }
                liveData.postValue(books)

            }
            .addOnFailureListener {
                liveData.postValue(emptyList())
            }
        return liveData

    }

    fun getFourthYearBooks(): LiveData<List<BooksData>> {

        val liveData = MutableLiveData<List<BooksData>>()
        database.child("FourtYear").get()

            .addOnSuccessListener { snapshot ->

                val books = snapshot.children.mapNotNull { it.getValue(BooksData::class.java) }
                liveData.postValue(books)

            }
            .addOnFailureListener {
                liveData.postValue(emptyList())
            }
        return liveData

    }

}