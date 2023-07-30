package com.example.imagespace.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import com.example.imagespace.components.ProgressLoader
import com.example.imagespace.components.ToolbarListener

abstract class BaseActivity<T : ViewDataBinding>(
    private val bindingInflater: (LayoutInflater) -> T
) : AppCompatActivity(),
    ProgressLoader,
    ToolbarListener {

    protected lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindingInflater(layoutInflater)
        setContentView(binding.root)
    }
}