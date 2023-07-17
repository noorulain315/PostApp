package com.example.post.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.data.models.State
import com.example.data.models.entity.CommentEntity
import com.example.data.models.entity.UserEntity
import com.example.domain.usecases.GetPostCommentsUserCase
import com.example.domain.usecases.GetPostUsersUseCase
import com.example.post.ui.viewmodels.PostDetailsViewModel
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
class PostDetailsViewModelTest {

    @get:Rule
    var instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @MockK
    lateinit var getPostsUsersUseCase: GetPostUsersUseCase

    @MockK
    lateinit var getPostCommentsUserCase: GetPostCommentsUserCase

    private lateinit var viewModel: PostDetailsViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true, relaxed = true)
        viewModel = PostDetailsViewModel(getPostCommentsUserCase, getPostsUsersUseCase)
        Dispatchers.setMain(UnconfinedTestDispatcher(TestCoroutineScheduler()))
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        clearAllMocks()
    }

    @Test
    fun `When post users load successfully`() {
        runTest {
            coEvery { getPostsUsersUseCase.invoke() } returns successPostUserResponse
            viewModel.getPostUserName(1)
            assert(viewModel.userState is State.Success)
        }
    }

    @Test
    fun `When post comments load successfully`() {
        runTest {
            coEvery { getPostCommentsUserCase.invoke() } returns successCommentUserResponse
            viewModel.getPostCommentsCount(1)
            assert(viewModel.commentState is State.Success)
        }
    }

    private val successPostUserResponse =
        listOf(UserEntity("a@gmail.com", 1, "Json", "2322234", "json12", "json.com"))
    private val successCommentUserResponse =
        listOf(CommentEntity("nice Post", "a@gmail.com", 1, "Json", 1))
}