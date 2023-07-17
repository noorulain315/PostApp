package com.example.data.repo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.data.models.entity.PostEntity
import com.example.data.remote.ApiService
import com.example.data.repositories.PostRepositoryImp
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.*
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class PostRepositoryImpTest  {

    @get:Rule
    var instantExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var apiService: ApiService

    private lateinit var postRepositoryImp: PostRepositoryImp

    private lateinit var mockWebServer: MockWebServer

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        apiService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
                )
            )
            .build()
            .create(ApiService::class.java)

        postRepositoryImp = PostRepositoryImp(apiService)

    }

    @After
    fun stopService() {
        mockWebServer.shutdown()
    }

    @Test
    fun `When post  load successfully`() {
        runTest {
            enqueueResponse("posts_response.json")
            val posts = postRepositoryImp.getAllPosts()
            Assert.assertEquals(posts[0].id, successPostResponse[0].id)
            Assert.assertEquals(posts.size, 1)
        }
    }

    private fun enqueueResponse(fileName: String, headers: Map<String, String> = emptyMap()) {
        val inputStream = javaClass.classLoader!!
            .getResourceAsStream("api-response/$fileName")
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        for ((key, value) in headers) {
            mockResponse.addHeader(key, value)
        }
        mockWebServer.enqueue(
            mockResponse
                .setBody(source.readString(Charsets.UTF_8))
        )
    }

    private val successPostResponse = listOf(PostEntity("A good day indeed", 1, "Morning", 2))
}