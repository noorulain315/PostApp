package com.example.domain.usecases

import com.example.data.models.entity.CommentEntity
import com.example.data.repositories.PostRepository

class GetPostCommentsUserCase(private val postRepository: PostRepository) {
    suspend fun invoke(): List<CommentEntity> {
        return postRepository.getPostComments()
    }
}