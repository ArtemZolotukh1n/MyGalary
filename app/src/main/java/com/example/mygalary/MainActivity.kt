package com.example.mygalary

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mygalary.model.Bebra
import com.example.mygalary.model.GalaryViewModel
import com.example.mygalary.ui.theme.MyGalaryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyGalaryTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    BebrasPhotosApp()
                }
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    PhotoItem(
        Bebra(R.string.photo_1, R.string.desc_1, R.drawable.bebra_pic_1, R.string.add_desc_1),
    )
}