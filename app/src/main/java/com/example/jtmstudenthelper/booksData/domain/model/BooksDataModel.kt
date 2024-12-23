package com.example.jtmstudenthelper.booksData.domain.model

import android.health.connect.datatypes.StepsCadenceRecord

data class BooksDataModel(
    val name: String = "",
    val imageUrl: String = ""
)

data class BooksData(

    val author : String = "",
    val bookImageUrl: String = "",
    val bookUrl: String = "",
    val catageroy: String = "",
    val description: String = "",
    val count: Int = 1
)
