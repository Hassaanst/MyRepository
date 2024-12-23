package com.example.jtmstudenthelper.vieflipper.presentation.adapter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jtmstudenthelper.data.repositorise.ViewPagerRepository
import com.example.jtmstudenthelper.vieflipper.domain.model.BannerImageModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BannerAdapterViewModel @Inject constructor(private val repository: ViewPagerRepository) :
    ViewModel() {


    private val _bannerImages = MutableLiveData<List<BannerImageModel>>()

    val bannerImages = _bannerImages

    init {
        fetchBannerImages()
    }

    private fun fetchBannerImages() {
        repository.fecthBannerImages().observeForever { images ->
            _bannerImages.value = images

        }
    }

}