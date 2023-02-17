package com.example.mygalary

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun BebraAdditionalDesc(addDesc: Int, modifier: Modifier = Modifier) {
    Text(text = stringResource(id = addDesc), modifier = modifier.padding(start = 8.dp, top = 8.dp))
}