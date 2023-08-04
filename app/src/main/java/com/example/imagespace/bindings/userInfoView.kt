package com.example.imagespace.bindings

import androidx.databinding.BindingAdapter
import com.example.imagespace.components.userinfo.UserInfoData
import com.example.imagespace.components.userinfo.UserInfoView

@BindingAdapter("app:setUserInfoData")
fun UserInfoView.setUserInfoData(data: UserInfoData?) {
    this.submitData(data)
}