package com.example.jtmstudenthelper.vieflipper.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.jtmstudenthelper.R
import com.example.jtmstudenthelper.vieflipper.domain.model.BannerImageModel

class BannerAdapter(
    private val bannerImages: List<BannerImageModel>
) : Adapter<BannerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.banner_item_view, parent, false)
        return BannerViewHolder(view)
    }


    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        val imageUrl = bannerImages[position].imageUrl
        Glide.with(holder.imageView.context)
            .load(imageUrl)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return bannerImages.size
    }

}

class BannerViewHolder(itemView: View) : ViewHolder(itemView) {
    val imageView = itemView.findViewById<ImageView>(R.id.bannerImageView)
}
