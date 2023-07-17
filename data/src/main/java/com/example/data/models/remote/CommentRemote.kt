package com.example.data.models.remote

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CommentRemote(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val postId: Int
)