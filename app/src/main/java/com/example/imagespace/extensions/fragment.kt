package com.example.imagespace.extensions

import android.app.Activity
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

fun Fragment.toast(message: String) {
    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
}

fun Fragment.toast(@StringRes messageId: Int) {
    Toast.makeText(requireContext(), messageId, Toast.LENGTH_SHORT).show()
}