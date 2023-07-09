package com.example.imagespace.extensions

import android.app.Activity
import android.widget.Toast
import androidx.annotation.StringRes

fun Activity.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Activity.toast(@StringRes messageId: Int) {
    Toast.makeText(this, messageId, Toast.LENGTH_SHORT).show()
}