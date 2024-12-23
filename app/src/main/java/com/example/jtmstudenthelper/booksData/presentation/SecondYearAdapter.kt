package com.example.jtmstudenthelper.booksData.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.jtmstudenthelper.R
import com.example.jtmstudenthelper.booksData.domain.model.BooksDataModel

class SecondYearAdapter(val booksData: List<BooksDataModel>, val context: Context) :Adapter<SecondYearViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondYearViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.books_data_item_view, parent, false)
        return SecondYearViewHolder(view)
    }

    override fun onBindViewHolder(holder: SecondYearViewHolder, position: Int) {

        val bookData = booksData[position]
        holder.bookName.text = bookData.name

        Glide.with(holder.itemView.context)
            .load(bookData.imageUrl)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return booksData.size
    }
}

class SecondYearViewHolder(itemView: View): ViewHolder(itemView) {

    val imageView = itemView.findViewById<ImageView>(R.id.bookImage)
    val bookName = itemView.findViewById<TextView>(R.id.bookName)

}