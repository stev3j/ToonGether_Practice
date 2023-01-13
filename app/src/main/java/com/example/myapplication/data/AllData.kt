package com.example.myapplication.data

import androidx.annotation.DrawableRes
import com.example.myapplication.R

data class WebToonData(
    @DrawableRes val drawable: Int,
)

val RecentDataList = listOf(
    R.drawable.example_image,
    R.drawable.example_image,
    R.drawable.example_image,
    R.drawable.example_image,
    R.drawable.example_image,
    R.drawable.example_image,
).map { WebToonData(it) }

val PopDataList = listOf(
    R.drawable.example_image2,
    R.drawable.example_image2,
    R.drawable.example_image2,
    R.drawable.example_image2,
    R.drawable.example_image2,
    R.drawable.example_image2,
).map { WebToonData(it) }