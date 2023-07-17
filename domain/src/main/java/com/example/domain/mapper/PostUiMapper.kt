package com.example.domain.mapper

import com.example.data.models.ui.CommentUiModel
import com.example.data.models.ui.PostUiModel
import com.example.data.models.remote.UserUiModel
import com.example.data.models.entity.CommentEntity
import com.example.data.models.entity.PostEntity
import com.example.data.models.entity.UserEntity


class PostUiMapper {

    fun mapToPostUiModel(model: PostEntity): PostUiModel {
        return with(model) {
            PostUiModel(
                body = model.body,
                id = id,
                title = title,
                userId = userId
            )
        }
    }

    fun mapToUserUiModel(models: List<UserEntity>, userId: Int): UserUiModel {
        val model = models.firstOrNull { it.id == userId }
        return UserUiModel(
            name = model?.name ?: "Not Found",
            phone = model?.phone ?: ""
        )
    }

    fun mapToCommentUiModel(models: List<CommentEntity>, postId: Int): CommentUiModel {
        val count = models.filter { it.postId == postId }.size.toString()
        return CommentUiModel(count = count)
    }
}