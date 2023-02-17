package com.example.mygalary.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Bebra(
    @StringRes val PicNumber: Int,
    @StringRes val PicDesc: Int,
    @DrawableRes val Picture: Int,
    @StringRes val additionalDesc: Int
)
