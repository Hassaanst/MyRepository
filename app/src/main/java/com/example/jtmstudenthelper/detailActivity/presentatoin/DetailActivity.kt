package com.example.jtmstudenthelper.detailActivity.presentatoin

import android.media.Image
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.jtmstudenthelper.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        val authorName = intent.extras?.getString("authorName")
        val authortxt = findViewById<TextView>(R.id.musanifname)
        authortxt.text = authorName

        val description = intent.extras?.getString("description")
        val destxt = findViewById<TextView>(R.id.description)
        destxt.text = description

        val imageId = intent.extras?.getString("imageUrl")
        val imageView = findViewById<ImageView>(R.id.imageView)

        Glide.with(this)
            .load(imageId)
            .into(imageView)


    }
}