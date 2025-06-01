package com.example.jtmstudenthelper

import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.jtmstudenthelper.messages.Message1
import com.example.jtmstudenthelper.messages.Message2
import com.example.jtmstudenthelper.messages.Message3
import com.example.jtmstudenthelper.vieflipper.presentation.adapter.BannerAdapter
import com.google.android.material.card.MaterialCardView
import com.google.firebase.analytics.FirebaseAnalytics
import dagger.hilt.android.AndroidEntryPoint
import java.util.Timer
import java.util.TimerTask
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityViewModel: MainActivityViewModel
    private lateinit var bannerViewPager: ViewPager2
    private lateinit var webView: WebView
    private var currentPage = 0
    private val scrollDelay: Long = 3000
    private var timer: Timer? = null
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Firebase Analytics کو انیشیئلائز کریں
        firebaseAnalytics = FirebaseAnalytics.getInstance(this)

        // SharedPreferences کا استعمال کریں تاکہ یہ چیک کیا جا سکے کہ پہلی بار ایپ اوپن ہو رہی ہے یا نہیں
        val sharedPreferences: SharedPreferences = getSharedPreferences("MyAppPrefs", MODE_PRIVATE)
        if (!sharedPreferences.getBoolean("isFirstTime", false)) {
            // Firebase پر custom event ٹریک کریں
            val params = Bundle()
            params.putString("event", "first_time_open")
            firebaseAnalytics.logEvent("app_opened", params)

            // اس بات کو ریکارڈ کریں کہ ایپ پہلی بار اوپن ہو چکی ہے
            with(sharedPreferences.edit()) {
                putBoolean("isFirstTime", true)
                apply()
            }
        }

        // Initialize ViewModel
        mainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        // Bind Views
        bannerViewPager = findViewById(R.id.bannerViewPager)
        webView = findViewById(R.id.webView)

        // Observe ViewModel for data
        observeViewModel()

        // Setup Banner ViewPager Auto Scroll
        setupBannerAutoScroll()

        // Setup WebView defaults
        setupWebViewDefaults()

        // Setup other UI components (Click Listeners)
        setupOtherUIComponents()
    }

    private fun observeViewModel() {
        // Observe Banner Images
        mainActivityViewModel.bannerImages.observe(this) { imageList ->
            setupBannerViewPager(imageList)
        }

        // Observe Video URL
        mainActivityViewModel.videoUrl.observe(this) { videoUrl ->
            if (videoUrl.isNullOrEmpty()) {
                webView.visibility = View.GONE
                adjustNotesCardViewPosition()
            } else {
                webView.visibility = View.VISIBLE
                loadWebView(videoUrl)
            }
        }
    }

    private fun setupBannerViewPager(imageList: List<String>) {
        val adapter = BannerAdapter(imageList)
        bannerViewPager.adapter = adapter
    }

    private fun setupBannerAutoScroll() {
        timer = Timer()
        timer?.schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    val itemCount = bannerViewPager.adapter?.itemCount ?: 0
                    if (itemCount > 0) {
                        if (currentPage >= itemCount) currentPage = 0
                        bannerViewPager.setCurrentItem(currentPage++, true)
                    }
                }
            }
        }, 0, scrollDelay)
    }

    private fun setupWebViewDefaults() {
        webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
        }

        // لنکس کو ویب ویو میں ہی لوڈ ہونے دیں
        webView.webViewClient = WebViewClient()
    }

    private fun loadWebView(videoUrl: String) {
        webView.loadUrl(videoUrl)

        // یوٹیوب ایپ میں ویڈیو کھولنے کے لیے کلک لسٹنر شامل کریں
        webView.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                // یوٹیوب ایپ میں ویڈیو کھولنے کے لیے انٹینٹ بنائیں
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl))
                intent.setPackage("com.google.android.youtube") // صرف یوٹیوب ایپ میں کھولنے کے لیے
                startActivity(intent)
                return@setOnTouchListener true
            }
            false
        }
    }

    private fun setupOtherUIComponents() {
        // YouTube Channel Icon Click Listener
        findViewById<ImageView>(R.id.youtubelogo).setOnClickListener {
            val channelURL = "https://www.youtube.com/@HafizHassaanFarooqAttari-co4jp"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(channelURL))
            startActivity(intent)
        }

        // Notes Button Click Listener
        findViewById<ImageView>(R.id.notesimageview).setOnClickListener {
            val intent = Intent(this, ClassesAboutNotes::class.java)
            startActivity(intent)
        }

        // Shuruhat Button Click Listener
        findViewById<ImageView>(R.id.sharahImageView).setOnClickListener {
            val intent = Intent(this, Message1::class.java)
            startActivity(intent)
        }

        // Mid Papers Button Click Listener
        findViewById<ImageView>(R.id.midpapersimageview).setOnClickListener {
            val intent = Intent(this, Message2::class.java)
            startActivity(intent)
        }

        // Final Papers Button Click Listener
        findViewById<ImageView>(R.id.finalpaperimageView).setOnClickListener {
            val intent = Intent(this, Message2::class.java)
            startActivity(intent)
        }

        // Logo Click Listener
        findViewById<ImageView>(R.id.logo).setOnClickListener {
            val intent = Intent(this, Message3::class.java)
            startActivity(intent)
        }
    }

    private fun adjustNotesCardViewPosition() {
        val notesCardView = findViewById<MaterialCardView>(R.id.notescardview)
        val constraintLayout = findViewById<ConstraintLayout>(R.id.completeCardView)

        val constraintSet = ConstraintSet()
        constraintSet.clone(constraintLayout)
        constraintSet.connect(
            notesCardView.id,
            ConstraintSet.TOP,
            R.id.bannerViewPager,
            ConstraintSet.BOTTOM,
            8 // Optional margin
        )
        constraintSet.applyTo(constraintLayout)
    }

    override fun onDestroy() {
        super.onDestroy()
        timer?.cancel()
    }
}

