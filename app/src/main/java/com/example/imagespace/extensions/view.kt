package com.example.imagespace.extensions

import android.view.View
import androidx.core.view.isVisible

fun View.toVisible() {
    this.isVisible = true
}

fun View.toGone() {
    this.isVisible = false
}