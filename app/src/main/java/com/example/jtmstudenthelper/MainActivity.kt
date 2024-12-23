package com.example.jtmstudenthelper

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.jtmstudenthelper.vieflipper.presentation.adapter.BannerAdapter
import com.example.jtmstudenthelper.vieflipper.presentation.adapter.BannerAdapterViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.Timer
import java.util.TimerTask

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : BannerAdapterViewModel
    private lateinit var bannerViewPager : ViewPager2
    private lateinit var timer : Timer
    private var crrunetPage = 0
    private var  scroolDelay : Long = 3000


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val youtubeIcon = findViewById<ImageView>(R.id.youtubelogo)
        youtubeIcon.setOnClickListener {
            val channelURL = "https://www.youtube.com/@HafizHassaanFarooqAttari-co4jp"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(channelURL))
            startActivity(intent)
        }

        val notesbtn = findViewById<ImageView>(R.id.notesimageview)
        notesbtn.setOnClickListener {
            val intent = Intent(this, ClassesAboutNotes::class.java)
            startActivity(intent)
        }

        val shuruhatbtn = findViewById<ImageView>(R.id.sharahImageView)
        shuruhatbtn.setOnClickListener {
            val intent = Intent(this, ClassesAboutShuruhat::class.java)
            startActivity(intent)
        }

        val midPapersbtn = findViewById<ImageView>(R.id.midpapersimageview)
        midPapersbtn.setOnClickListener {
            val intent = Intent(this, ClassesAboutMidPapers::class.java)
            startActivity(intent)
        }

        val finalpapersbtn = findViewById<ImageView>(R.id.finalpaperimageView)
        finalpapersbtn.setOnClickListener {
            val intent = Intent(this, ClassesAboutFinalPapers::class.java)
            startActivity(intent)
        }


        viewModel = ViewModelProvider(this).get(BannerAdapterViewModel::class.java)
        bannerViewPager = findViewById(R.id.bannerViewPager)

        viewModel.bannerImages.observe(this, { imageList->
            val adapter = BannerAdapter(imageList)
            bannerViewPager.adapter = adapter
            setupAutoScroll(imageList.size)


        })



    }

    private fun setupAutoScroll(imageCount : Int) {
        timer =  Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    if (crrunetPage == imageCount) {
                        crrunetPage = 0
                    }
                    bannerViewPager.setCurrentItem(crrunetPage++, true)
                }
            }
        }, 0, scroolDelay )
    }
    }