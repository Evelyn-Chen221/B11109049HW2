package com.example.b11109049hw2.data

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


@SuppressLint("SupportAnnotationUsage")
data class Place @SuppressLint("SupportAnnotationUsage") constructor(
    @StringRes val name: String,
    @DrawableRes val imageResourceId: Int,
    @StringRes val description: String,
    val latitude: Double,
    val longitude: Double
)


