package com.example.jtmstudenthelper.vieflipper.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.jtmstudenthelper.R

class BannerAdapter(
    private val bannerImages: List<String> // List of image URLs
) : RecyclerView.Adapter<BannerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.banner_item_view, parent, false)
        return BannerViewHolder(view)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        val imageUrl = bannerImages[position] // Directly get the string from the list
        Glide.with(holder.imageView.context)
            .load(imageUrl) // Use the URL directly
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return bannerImages.size
    }
}

class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imageView: ImageView = itemView.findViewById(R.id.bannerImageView)
}

