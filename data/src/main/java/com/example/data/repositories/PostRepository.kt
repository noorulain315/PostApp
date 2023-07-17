package com.example.data.repositories

import com.example.data.models.entity.CommentEntity
import com.example.data.models.entity.PostEntity
import com.example.data.models.entity.UserEntity

/**
 * Repository of data sources.
 */
interface PostRepository {

    suspend fun getAllPosts(): List<PostEntity>

    suspend fun getPostUsers(): List<UserEntity>

    suspend fun getPostComments(): List<CommentEntity>
}