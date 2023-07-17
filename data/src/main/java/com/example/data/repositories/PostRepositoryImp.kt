package com.example.data.repositories

import com.example.data.models.remote.mappers.PostEntityMapper
import com.example.data.remote.ApiService
import com.example.data.models.entity.CommentEntity
import com.example.data.models.entity.PostEntity
import com.example.data.models.entity.UserEntity
import javax.inject.Inject

/**
* Implementation of Repository
*/
class PostRepositoryImp @Inject constructor(private val apiService: ApiService) :
    PostRepository {
    private val entityMapper by lazy { PostEntityMapper() }

    override suspend fun getAllPosts(): List<PostEntity> {
        return apiService.getAllPost().map { entityMapper.mapToPostEntityModel(it) }
    }

    override suspend fun getPostUsers(): List<UserEntity> {
        return apiService.getUsers().map { entityMapper.mapToUserEntityModel(it) }
    }

    override suspend fun getPostComments(): List<CommentEntity> {
        return apiService.getAllComments().map { entityMapper.mapToCommentEntityModel(it) }
    }
}