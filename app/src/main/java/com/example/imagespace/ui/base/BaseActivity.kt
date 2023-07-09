package com.example.imagespace.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<T : ViewDataBinding>(
    private val bindingInflater: (LayoutInflater) -> T
) : AppCompatActivity() {

    protected lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindingInflater(LayoutInflater.from(this))
        setContentView(binding.root)
    }
}