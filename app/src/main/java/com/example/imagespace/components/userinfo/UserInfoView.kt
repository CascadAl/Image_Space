package com.example.imagespace.components.userinfo

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.imagespace.databinding.ViewUserInfoBinding

class UserInfoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding: ViewUserInfoBinding =
        ViewUserInfoBinding.inflate(LayoutInflater.from(context), this, true)

    fun submitData(data: UserInfoData?) {
        data?.let {
            binding.data = it
        }
    }
}