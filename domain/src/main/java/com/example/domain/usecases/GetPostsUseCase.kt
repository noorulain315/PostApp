package com.example.domain.usecases

import com.example.data.models.entity.PostEntity
import com.example.data.repositories.PostRepository

class GetPostsUseCase(private val postRepository: PostRepository) {
    suspend fun invoke(): List<PostEntity> {
        return postRepository.getAllPosts()
    }
}