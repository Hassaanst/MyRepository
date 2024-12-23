package com.example.jtmstudenthelper.fourthyearnotes.presentation

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.jtmstudenthelper.R
import com.example.jtmstudenthelper.booksData.domain.model.BooksData
import com.example.jtmstudenthelper.detailActivity.presentatoin.DetailActivity
import org.w3c.dom.Text

class FourthYearDataAdapter(val data: List<BooksData>, val context: Context) :
    Adapter<FourthYearViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FourthYearViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_view_for_fecthing_books_data, parent, false)
        return FourthYearViewHolder(view)
    }


    override fun onBindViewHolder(holder: FourthYearViewHolder, position: Int) {

        val data = data[position]
        holder.authorName.text = data.author
        holder.description.text = data.description
        holder.category.text = data.catageroy
        holder.count.text = data.count.toString()

        Glide.with(holder.itemView.context)
            .load(data.bookImageUrl)
            .into(holder.imageView)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("authorName", data.author)
            intent.putExtra("description", data.description)
            intent.putExtra("imageUrl", data.bookImageUrl)


            context.startActivity(intent)
        }

    }


    override fun getItemCount(): Int {
        return data.size
    }

}

class FourthYearViewHolder(itemView: View) : ViewHolder(itemView) {

    val authorName = itemView.findViewById<TextView>(R.id.author_name)
    val category = itemView.findViewById<TextView>(R.id.book_title)
    val description = itemView.findViewById<TextView>(R.id.description)
    val imageView = itemView.findViewById<ImageView>(R.id.imageView)
    val count = itemView.findViewById<TextView>(R.id.book_number)

}