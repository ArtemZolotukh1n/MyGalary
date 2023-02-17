package com.example.mygalary

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mygalary.model.Bebra

@Composable
fun PhotoItem(bebra: Bebra, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    Card(elevation = 4.dp, modifier = modifier
        .padding(8.dp)
        .clickable { expanded = !expanded }) {
        Column(
            modifier = modifier
                .padding(8.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ) {
            Text(
                text = stringResource(id = bebra.PicNumber),
                style = MaterialTheme.typography.h1,
                modifier = modifier.padding(bottom = 8.dp)
            )
            Text(
                text = stringResource(id = bebra.PicDesc),
                style = MaterialTheme.typography.body1,
                modifier = modifier.padding(bottom = 8.dp)
            )
            Image(
                painter = painterResource(id = bebra.Picture),
                contentDescription = stringResource(id = bebra.PicDesc),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(256.dp)
                    .clip(RoundedCornerShape(12))
            )
            if (expanded) {
                BebraAdditionalDesc(bebra.additionalDesc)
            }
        }

    }
}