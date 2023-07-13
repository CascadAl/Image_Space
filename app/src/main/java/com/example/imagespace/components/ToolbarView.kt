package com.example.imagespace.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.imagespace.databinding.ViewToolbarBinding

class ToolbarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding: ViewToolbarBinding =
        ViewToolbarBinding.inflate(LayoutInflater.from(context), this, true)

    fun setOnBackClickListener(listener: OnBackClickListener) {
        listener.onClick()
    }

    interface OnBackClickListener {
        fun onClick()
    }
}