package com.example.imagespace.network.model.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PhotoResponse(
    val id: String
) : Parcelable
