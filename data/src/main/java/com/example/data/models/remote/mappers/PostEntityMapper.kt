package com.example.data.models.remote.mappers

import com.example.data.models.remote.CommentRemote
import com.example.data.models.remote.PostRemote
import com.example.data.models.remote.UserRemote
import com.example.data.models.entity.CommentEntity
import com.example.data.models.entity.PostEntity
import com.example.data.models.entity.UserEntity

class PostEntityMapper {

    fun mapToPostEntityModel(model: PostRemote): PostEntity {
        return with(model) {
            PostEntity(
                body = model.body,
                id = id,
                title = title,
                userId = userId
            )
        }
    }

    fun mapToCommentEntityModel(model: CommentRemote): CommentEntity {
        return with(model) {
            CommentEntity(
                body = model.body,
                id = id,
                email = email,
                postId = postId,
                name = name
            )
        }
    }

    fun mapToUserEntityModel(model: UserRemote): UserEntity {
        return with(model) {
            UserEntity(
                email = email,
                id = id,
                name = name,
                phone = phone,
                username = username,
                website = website
            )
        }
    }
}