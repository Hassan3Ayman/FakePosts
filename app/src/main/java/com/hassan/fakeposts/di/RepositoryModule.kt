package com.hassan.fakeposts.di

import com.hassan.fakeposts.data.remote.PostRepositoryImp
import com.hassan.fakeposts.domain.repository.PostRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindUserRepository(repository: PostRepositoryImp): PostRepository
}