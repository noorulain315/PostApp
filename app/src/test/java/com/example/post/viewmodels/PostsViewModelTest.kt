package com.example.post.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.data.models.State
import com.example.data.models.entity.PostEntity
import com.example.domain.usecases.GetPostsUseCase
import com.example.post.ui.viewmodels.PostsViewModel
import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class PostsViewModelTest {

    @get:Rule
    var instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @MockK
    lateinit var getPostsUseCase: GetPostsUseCase

    private lateinit var viewModel: PostsViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true, relaxed = true)
        viewModel = PostsViewModel(getPostsUseCase)
        Dispatchers.setMain(UnconfinedTestDispatcher(TestCoroutineScheduler()))
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        clearAllMocks()
    }

    @Test
    fun `When posts load successfully`() {
        runTest {
            coEvery { getPostsUseCase.invoke() } returns successPostResponse
            viewModel.getAllPosts()
            assert(viewModel.postsState is State.Success)
        }
    }

    @Test
    fun `When posts load unsuccessfully`() {
        runTest {
            coEvery { getPostsUseCase.invoke() }
            viewModel.getAllPosts()
            assert(viewModel.postsState is State.Error)
        }
    }

    private val successPostResponse = listOf(PostEntity("A good day indeed", 1, "Morning", 2))


}