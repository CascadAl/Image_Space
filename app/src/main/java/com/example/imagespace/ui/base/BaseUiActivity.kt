package com.example.imagespace.ui.base

import android.view.LayoutInflater
import androidx.databinding.ViewDataBinding
import com.example.imagespace.R
import com.example.imagespace.components.*
import com.example.imagespace.extensions.toGone
import com.example.imagespace.extensions.toVisible

abstract class BaseUiActivity<T : ViewDataBinding>(
    bindingInflater: (LayoutInflater) -> T
) : BaseActivity<T>(bindingInflater),
    ProgressLoader,
    ToolbarListener {

    private val toolbar: ToolbarView? by lazy {
        binding.root.findViewById(R.id.toolbar)
    }
    private val progress: ProgressView? by lazy {
        binding.root.findViewById(R.id.progress)
    }

    override fun showLoader() {
        progress?.showProgress() ?: progressViewError()
    }

    override fun hideLoader() {
        progress?.hideProgress() ?: progressViewError()
    }

    override fun showToolbar() {
        toolbar?.toVisible() ?: toolbarViewError()
    }

    override fun hideToolbar() {
        toolbar?.toGone() ?: toolbarViewError()
    }

    override fun setOnBackClickListener(listener: OnBackClickListener) {
        toolbar?.setOnBackClickListener(listener) ?: toolbarViewError()
    }

    private fun toolbarViewError(): Nothing =
        error("ToolbarView has not been added to the screen. Make sure you added toolbar to your activity and set android:id=\"@+id/toolbar\"")

    private fun progressViewError(): Nothing =
        error("ProgressView has not been added to the screen. Make sure you added progress to your activity and set android:id=\"@+id/progress\"")
}