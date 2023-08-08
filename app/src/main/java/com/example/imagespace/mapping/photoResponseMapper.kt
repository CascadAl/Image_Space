package com.example.imagespace.mapping

import com.example.imagespace.components.userinfo.UserInfoData
import com.example.imagespace.network.model.response.PhotoResponse
import com.example.imagespace.network.model.response.User
import com.example.imagespace.ui.main.discover.adapter.NewPhotoViewData

fun PhotoResponse.toNewPhotoData(): NewPhotoViewData = NewPhotoViewData(
    id = id.orEmpty(),
    imageUrl = urls?.regular.orEmpty(),
    userInfo = user?.toUserInfoData()
)

fun User.toUserInfoData(): UserInfoData = UserInfoData(
    imageUrl = profileImage?.small.orEmpty(),
    name = name.orEmpty(),
    userName = username.orEmpty()
)