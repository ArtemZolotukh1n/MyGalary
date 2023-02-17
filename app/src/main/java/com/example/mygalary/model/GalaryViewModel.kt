package com.example.mygalary.model

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.mygalary.R

class GalaryViewModel(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
        val loadedPics = savedStateHandle.getStateFlow(
        "pics", initialValue = mutableListOf<Bebra>(
            Bebra(R.string.photo_1, R.string.desc_1, R.drawable.bebra_pic_1, R.string.add_desc_1),
            Bebra(R.string.photo_2, R.string.desc_2, R.drawable.bebra_pic_2, R.string.add_desc_2),
            Bebra(R.string.photo_3, R.string.desc_3, R.drawable.bebra_pic_3, R.string.add_desc_3)
        )
    )



    fun addPicture() {
        val additionalBebraPhoto = Bebra(
            R.string.photo_placeholder,
            R.string.desc_placeholder,
            R.drawable.placeholder_cat,
            R.string.add_desc_placeholder
        )
        savedStateHandle.get<MutableList<Bebra>>("pics")!!.add(additionalBebraPhoto)
    }
}