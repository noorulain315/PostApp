package com.example.post.di.module

import com.example.data.remote.ApiService
import com.example.data.repositories.PostRepositoryImp
import com.example.data.repositories.PostRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    @Singleton
    fun providesPostRepository(apiService: ApiService): PostRepository {
        return PostRepositoryImp(apiService)
    }
}