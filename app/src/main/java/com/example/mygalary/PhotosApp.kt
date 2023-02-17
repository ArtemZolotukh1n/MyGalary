package com.example.mygalary

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mygalary.model.GalaryViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BebrasPhotosApp() {
    val galaryViewModel = viewModel<GalaryViewModel>()
    val allPhotos by galaryViewModel.loadedPics.collectAsState()
    Scaffold(topBar = { BebraTopAppBar() }, floatingActionButton = {
        FloatingActionButton(
            onClick = { galaryViewModel.addPicture() },
            backgroundColor = MaterialTheme.colors.onBackground
        ) {
            Icon(
                imageVector = Icons.Rounded.Add,
                contentDescription = "Add Photo",
                tint = Color.White,
            )
        }
    }) {
        LazyColumn(modifier = Modifier.background(color = MaterialTheme.colors.background)) {
            items(allPhotos) {
                PhotoItem(bebra = it)
            }
        }
    }

}