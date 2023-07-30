package com.example.imagespace.api

import com.example.imagespace.network.model.response.PhotoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DiscoverApi {

    enum class PhotoOrderType(val value: String) {
        LATEST("latest"),
        POPULAR("popular")
    }

    @GET(QueryConstants.PHOTOS)
    suspend fun getPhotos(
        @Query(ParamConstants.ORDER_BY) orderBy: String,
        @Query(ParamConstants.PAGE) page: Int,
        @Query(ParamConstants.PER_PAGE) perPage: Int
    ): Response<List<PhotoResponse>>
}