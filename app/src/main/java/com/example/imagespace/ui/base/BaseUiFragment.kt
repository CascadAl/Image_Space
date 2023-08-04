package com.example.imagespace.ui.base

import android.view.LayoutInflater
import androidx.databinding.ViewDataBinding
import com.example.imagespace.components.ProgressLoader
import com.example.imagespace.components.ToolbarListener

abstract class BaseUiFragment<T : ViewDataBinding>(
    bindingInflater: (LayoutInflater) -> T
) : BaseFragment<T>(bindingInflater) {

    protected val progress: ProgressLoader by lazy { activity as ProgressLoader }
    protected val toolbar: ToolbarListener by lazy { activity as ToolbarListener }
}