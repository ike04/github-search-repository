package com.google.codelab.github_search_repository.di

import com.google.codelab.github_search_repository.repository.SearchDataRepository
import com.google.codelab.github_search_repository.repository.SearchDataRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindSearchDataRepository(searchDataRepositoryImpl: SearchDataRepositoryImpl): SearchDataRepository
}
