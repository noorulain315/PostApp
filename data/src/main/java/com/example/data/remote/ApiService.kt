package com.example.data.remote

import com.example.data.models.remote.CommentRemote
import com.example.data.models.remote.PostRemote
import com.example.data.models.remote.UserRemote
import retrofit2.http.GET

/**
 * Service to fetch Data from API endpoint.
 */
interface ApiService {
    @GET("posts")
    suspend fun getAllPost(): List<PostRemote>

    @GET("users")
    suspend fun getUsers(): List<UserRemote>

    @GET("comments")
    suspend fun getAllComments(): List<CommentRemote>
}
