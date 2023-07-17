package com.example.domain.usecases

import com.example.data.models.entity.PostEntity
import com.example.domain.fakeRepo.PostRepositoryFake
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class GetPostsUseCaseTest  {

    private lateinit var getPostsUseCase: GetPostsUseCase

    @Before
    fun setUp() {
        val postRepository = PostRepositoryFake()
        getPostsUseCase = GetPostsUseCase(postRepository)
    }

    @Test
    fun `When post load successfully`() {
        runTest {
            val postEntities: List<PostEntity> = getPostsUseCase.invoke()
            assert(1 == postEntities.size)
        }
    }

}