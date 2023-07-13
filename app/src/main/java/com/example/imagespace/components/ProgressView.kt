package com.example.imagespace.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.Window
import android.view.WindowManager
import android.widget.FrameLayout
import com.example.imagespace.R
import com.example.imagespace.databinding.ViewProgressBinding
import com.example.imagespace.extensions.toGone
import com.example.imagespace.extensions.toVisible

class ProgressView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttrs: Int = 0
) : FrameLayout(context, attrs, defStyleAttrs) {

    private val binding: ViewProgressBinding =
        ViewProgressBinding.inflate(LayoutInflater.from(context), this, true)

    private var window: Window? = null
    private var isLoading: Boolean = false

    init {
        context.theme.obtainStyledAttributes(attrs, R.styleable.ProgressView, defStyleAttrs, 0)
            .let {
                val isProgressShow = it.getBoolean(R.styleable.ProgressView_showProgress, false)
                if (isProgressShow) {
                    showProgress()
                } else {
                    hideProgress()
                }
            }
    }

    fun setWindow(window: Window) {
        this.window = window
        setScreenTouchable(isLoading)
    }

    fun showProgress() {
        isLoading = true
        setScreenTouchable(true)
        binding.container.toVisible()
    }

    fun hideProgress() {
        isLoading = false
        setScreenTouchable(false)
        binding.container.toGone()
    }

    private fun setScreenTouchable(isLoaded: Boolean) {
        if (isLoaded) {
            window?.setFlags(
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
            )
        } else {
            window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
        }
    }
}

interface ProgressLoader {
    fun showLoader()
    fun hideLoader()
}