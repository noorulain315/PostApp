package com.example.data.models.remote

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PostRemote(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)