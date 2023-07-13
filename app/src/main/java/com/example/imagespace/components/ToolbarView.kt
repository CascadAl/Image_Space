package com.example.imagespace.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.imagespace.databinding.ViewToolbarBinding

typealias OnBackClickListener = () -> Unit

class ToolbarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding: ViewToolbarBinding =
        ViewToolbarBinding.inflate(LayoutInflater.from(context), this, true)

    fun setOnBackClickListener(listener: OnBackClickListener) {
        binding.btnBack.setOnClickListener {
            listener.invoke()
        }
    }
}

interface ToolbarListener {
    fun showToolbar()
    fun hideToolbar()
    fun setOnBackClickListener(listener: OnBackClickListener)
}