package com.example.data.models.entity

data class CommentEntity(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val postId: Int
)