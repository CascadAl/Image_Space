package com.example.imagespace.repository.discover

import com.example.imagespace.api.DiscoverApi
import com.example.imagespace.network.ApiResponse
import com.example.imagespace.network.BaseRepository
import com.example.imagespace.network.model.response.PhotoResponse
import javax.inject.Inject

class DiscoverRepositoryImpl @Inject constructor(
    private val api: DiscoverApi
) : BaseRepository(), DiscoverRepository {

    override suspend fun getNewPhotos(
        page: Int,
        perPage: Int
    ): ApiResponse<List<PhotoResponse>> = request {
        api.getPhotos(
            DiscoverApi.PhotoOrderType.LATEST.value,
            page,
            perPage
        )
    }

    override suspend fun getPopularPhotos(
        page: Int,
        perPage: Int
    ): ApiResponse<List<PhotoResponse>> = request {
        api.getPhotos(
            DiscoverApi.PhotoOrderType.POPULAR.value,
            page,
            perPage
        )
    }
}