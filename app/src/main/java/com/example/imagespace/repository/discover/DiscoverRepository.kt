package com.example.imagespace.repository.discover

import com.example.imagespace.network.ApiResponse
import com.example.imagespace.network.model.response.PhotoResponse

interface DiscoverRepository {

    suspend fun getNewPhotos(
        page: Int,
        perPage: Int
    ): ApiResponse<List<PhotoResponse>>

    suspend fun getPopularPhotos(
        page: Int,
        perPage: Int
    ): ApiResponse<List<PhotoResponse>>
}