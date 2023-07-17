package com.example.post.ui.viewmodels


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.models.State
import com.example.data.models.ui.PostUiModel
import com.example.domain.mapper.PostUiMapper
import com.example.domain.usecases.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for PostsFragment
 */
@HiltViewModel
class PostsViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase
) : ViewModel() {

    private val postUiMapper by lazy { PostUiMapper() }
    var postsState by mutableStateOf<State<List<PostUiModel>>>(State.loading())
        private set

    /**
     * Get Posts from Endpoint.
     */
    fun getAllPosts() {
        viewModelScope.launch {
            runCatching {
                postsState = State.loading()
                getPostsUseCase.invoke()
            }.onSuccess { it ->
                postsState = State.success(it.map { postUiMapper.mapToPostUiModel(it) })
            }.onFailure {
                postsState = State.error(it.message ?: "Failed to load posts")
            }
        }
    }
}