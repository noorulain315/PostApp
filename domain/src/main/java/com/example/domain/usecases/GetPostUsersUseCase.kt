package com.example.domain.usecases

import com.example.data.models.entity.UserEntity
import com.example.data.repositories.PostRepository

class GetPostUsersUseCase(private val postRepository: PostRepository) {
    suspend fun invoke(): List<UserEntity> {
        return postRepository.getPostUsers()
    }
}