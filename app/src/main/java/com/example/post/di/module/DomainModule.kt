package com.example.post.di.module

import com.example.data.repositories.PostRepository
import com.example.domain.usecases.GetPostCommentsUserCase
import com.example.domain.usecases.GetPostsUseCase
import com.example.domain.usecases.GetPostUsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    @Singleton
    fun provideGetPostsUseCase(postRepository: PostRepository) =
        GetPostsUseCase(postRepository)

    @Provides
    @Singleton
    fun provideGetUsersUseCase(postRepository: PostRepository) =
        GetPostUsersUseCase(postRepository)

    @Provides
    @Singleton
    fun provideCommentsUseCase(postRepository: PostRepository) =
        GetPostCommentsUserCase(postRepository)

}