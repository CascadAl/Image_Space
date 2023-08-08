package com.example.imagespace.ui.main.discover.adapter

import com.example.imagespace.common.pagination.GenPagingViewData
import com.example.imagespace.components.userinfo.UserInfoData

data class NewPhotoViewData(
    override val id: String,
    val imageUrl: String,
    val userInfo: UserInfoData?
) : GenPagingViewData(id)