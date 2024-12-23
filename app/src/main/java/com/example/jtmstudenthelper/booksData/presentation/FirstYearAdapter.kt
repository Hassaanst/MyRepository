package com.example.jtmstudenthelper.booksData.presentation

import android.content.Context
import android.provider.ContactsContract.CommonDataKinds.Im
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
import org.w3c.dom.Text

class FirstYearAdapter(val booksData: List<BooksDataModel>, val context: Context) :
    Adapter<FirstYearViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstYearViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.books_data_item_view, parent, false)
        return FirstYearViewHolder(view)
    }

    override fun onBindViewHolder(holder: FirstYearViewHolder, position: Int) {

        val bookData = booksData[position]
        holder.bookName.text = bookData.name

        Glide.with(holder.itemView.context)
            .load(bookData.imageUrl)
            .into(holder.imageView)

    }

    override fun getItemCount(): Int {
        return  booksData.size
    }
}

class FirstYearViewHolder(itemView: View) : ViewHolder(itemView) {

    val imageView = itemView.findViewById<ImageView>(R.id.bookImage)
    val bookName = itemView.findViewById<TextView>(R.id.bookName)
}