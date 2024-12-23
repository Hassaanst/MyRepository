package com.example.jtmstudenthelper.data.repositorise

import androidx.lifecycle.MutableLiveData
import com.example.jtmstudenthelper.vieflipper.domain.model.BannerImageModel
import com.google.firebase.storage.FirebaseStorage
import javax.inject.Inject

class ViewPagerRepository @Inject constructor() {

    private val storageRefrence = FirebaseStorage.getInstance().reference
    private val folderRefrence = storageRefrence.child("viewflipperpictures/")

    fun fecthBannerImages(): MutableLiveData<List<BannerImageModel>> {

        val imagesLiveData = MutableLiveData<List<BannerImageModel>>()
        val imageList = mutableListOf<BannerImageModel>()
        folderRefrence.listAll().addOnSuccessListener { listResult ->
            val totalFiles = listResult.items.size
            var downloadedCount = 0

            for (fileRef in listResult.items) {
                fileRef.downloadUrl.addOnSuccessListener { url ->
                    imageList.add(BannerImageModel(url.toString()))
                    downloadedCount++

                    if (downloadedCount == totalFiles) {
                        imagesLiveData.value = imageList
                    }

                }


            }
        }

        return imagesLiveData
    }


}