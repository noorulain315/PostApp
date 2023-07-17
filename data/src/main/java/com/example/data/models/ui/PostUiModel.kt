package com.example.data.models.ui

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PostUiModel(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
) : Parcelable