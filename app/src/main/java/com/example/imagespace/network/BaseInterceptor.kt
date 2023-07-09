package com.example.imagespace.network

import com.example.imagespace.BuildConfig
import okhttp3.*

class BaseInterceptor : Interceptor, Authenticator {

    private val baseHeaders = mapOf(
        AUTHORIZATION to "$CLIENT_ID ${BuildConfig.ACCESS_KEY}",
        ACCEPT_VERSION to "v1"
    )

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        request = request.newBuilder()
            .addHeaders(baseHeaders)
            .build()
        return chain.proceed(request)
    }

    override fun authenticate(route: Route?, response: Response): Request? {
        TODO("check if needed")
    }

    private fun Request.Builder.addHeaders(headers: Map<String, String>): Request.Builder {
        headers.forEach(this::addHeader)
        return this
    }

    private companion object {
        const val AUTHORIZATION = "Authorization"
        const val ACCEPT_VERSION = "Accept-Version"
        const val CLIENT_ID = "Client-ID"
    }
}