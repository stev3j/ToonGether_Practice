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

val MyRecentDataList = listOf(
    R.drawable.bike_king,
    R.drawable.black_wizard,
    R.drawable.dog,
    R.drawable.dolboong,
    R.drawable.firechicken_soup,
    R.drawable.ice_cream,
    R.drawable.like,
    R.drawable.lonely_dev,
    R.drawable.mandarin,
    R.drawable.rakyu,
    R.drawable.sixteen_cm,
    R.drawable.solt_slave,
    R.drawable.stalker,
    R.drawable.thorn,
    R.drawable.wizard,
).map { WebToonData(it) }