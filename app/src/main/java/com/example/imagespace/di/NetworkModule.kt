package com.example.imagespace.di

import com.example.imagespace.BuildConfig
import com.example.imagespace.api.DiscoverApi
import com.example.imagespace.network.BaseInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(BaseInterceptor())
        .authenticator(BaseInterceptor())
        .build()

    @Provides
    @Singleton
    fun provideDiscoverApi(retrofit: Retrofit): DiscoverApi =
        retrofit.create(DiscoverApi::class.java)
}