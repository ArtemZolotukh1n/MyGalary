package com.example.mygalary.model

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.mygalary.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GalaryViewModel(application: Application) : AndroidViewModel(application) {

    private val _loadedPics = MutableStateFlow(emptyList<Bebra>())
    val loadedPics: StateFlow<List<Bebra>> = _loadedPics

    init {
        viewModelScope.launch {
            _loadedPics.value = loadPhotosFromPref()
        }
    }

    fun addPicture() {
        val additionalBebraPhoto = Bebra(
            R.string.photo_placeholder,
            R.string.desc_placeholder,
            R.drawable.placeholder_cat,
            R.string.add_desc_placeholder
        )
        viewModelScope.launch {
            val updatedList = _loadedPics.value.toMutableList()
            updatedList.add(additionalBebraPhoto)
            _loadedPics.value = updatedList
            savePhotosToPrefs(updatedList)
        }
    }

    private suspend fun savePhotosToPrefs(photos: List<Bebra>) {
        withContext(Dispatchers.IO) {
            val prefs =
                getApplication<Application>().getSharedPreferences("photos", Context.MODE_PRIVATE)
            val json = Gson().toJson(photos)
            prefs.edit().putString("photos", json).apply()
        }
    }

    private suspend fun loadPhotosFromPref(): MutableList<Bebra> {
        return withContext(Dispatchers.IO) {
            val prefs =
                getApplication<Application>().getSharedPreferences("photos", Context.MODE_PRIVATE)
            val json = prefs.getString("photos", null)
            if (json != null) {
                Gson().fromJson(json, object : TypeToken<MutableList<Bebra>>() {}.type)
            } else {
                mutableListOf(
                    Bebra(
                        R.string.photo_1,
                        R.string.desc_1,
                        R.drawable.bebra_pic_1,
                        R.string.add_desc_1
                    ),
                    Bebra(
                        R.string.photo_2,
                        R.string.desc_2,
                        R.drawable.bebra_pic_2,
                        R.string.add_desc_2
                    ),
                    Bebra(
                        R.string.photo_3,
                        R.string.desc_3,
                        R.drawable.bebra_pic_3,
                        R.string.add_desc_3
                    )
                )
            }
        }
    }
}