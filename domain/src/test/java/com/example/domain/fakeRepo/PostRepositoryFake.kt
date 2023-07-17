package com.example.domain.fakeRepo

import com.example.data.models.entity.CommentEntity
import com.example.data.models.entity.PostEntity
import com.example.data.models.entity.UserEntity
import com.example.data.repositories.PostRepository

class PostRepositoryFake : PostRepository {

    override suspend fun getAllPosts(): List<PostEntity> {
        return listOf(PostEntity("A good day indeed", 1, "Morning", 2))
    }

    override suspend fun getPostUsers(): List<UserEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun getPostComments(): List<CommentEntity> {
        TODO("Not yet implemented")
    }
}