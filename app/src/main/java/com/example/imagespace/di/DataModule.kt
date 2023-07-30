package com.example.imagespace.di

import com.example.imagespace.repository.discover.DiscoverRepository
import com.example.imagespace.repository.discover.DiscoverRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun provideDiscoverRepository(repository: DiscoverRepositoryImpl): DiscoverRepository
}