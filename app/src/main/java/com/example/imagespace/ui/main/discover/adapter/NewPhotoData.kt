package com.example.imagespace.ui.main.discover.adapter

import com.example.imagespace.common.GenViewData
import com.example.imagespace.components.userinfo.UserInfoData

data class NewPhotoData(
    val id: String,
    val imageUrl: String,
    val userInfo: UserInfoData?
) : GenViewData()