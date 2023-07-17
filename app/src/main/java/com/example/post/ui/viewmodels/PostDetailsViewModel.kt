package com.example.post.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.models.State
import com.example.data.models.remote.UserUiModel
import com.example.data.models.ui.CommentUiModel
import com.example.domain.mapper.PostUiMapper
import com.example.domain.usecases.GetPostCommentsUserCase
import com.example.domain.usecases.GetPostUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for PostDetailsFragment
 */
@HiltViewModel
class PostDetailsViewModel @Inject constructor(
    private val getCommentsUserCase: GetPostCommentsUserCase,
    private val getUsersUseCase: GetPostUsersUseCase
) : ViewModel() {

    private val postUiMapper by lazy { PostUiMapper() }

    var userState by mutableStateOf<State<UserUiModel>>(State.loading())
        private set
    var commentState by mutableStateOf<State<CommentUiModel>>(State.loading())
        private set

    /**
     * Get Post User/Author from Endpoint.
     */
    fun getPostUserName(userId: Int) {
        viewModelScope.launch {
            runCatching {
                userState = State.loading()
                getUsersUseCase.invoke()
            }.onSuccess {
                userState = State.success(postUiMapper.mapToUserUiModel(it, userId))
            }.onFailure {
                userState = State.error(it.message ?: "Failed to load user data")
            }
        }
    }

    /**
     * Get Post Total Comments from Endpoint.
     */
    fun getPostCommentsCount(postId: Int) {
        viewModelScope.launch {
            runCatching {
                commentState = State.loading()
                getCommentsUserCase.invoke()
            }.onSuccess {
                commentState = State.success(postUiMapper.mapToCommentUiModel(it, postId))
            }.onFailure {
                commentState = State.error(it.message ?: "Failed to load comments")
            }
        }
    }
}