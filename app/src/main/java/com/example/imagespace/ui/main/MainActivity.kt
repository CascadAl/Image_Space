package com.example.imagespace.ui.main

import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.fragment.NavHostFragment
import com.example.imagespace.R
import com.example.imagespace.components.OnBackClickListener
import com.example.imagespace.databinding.ActivityMainBinding
import com.example.imagespace.extensions.toGone
import com.example.imagespace.extensions.toVisible
import com.example.imagespace.extensions.toast
import com.example.imagespace.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController

        binding.navView.setupWithNavController(navController)
    }

    override fun showLoader() {
        binding.progress.showProgress()
    }

    override fun hideLoader() {
        binding.progress.hideProgress()
    }

    override fun showToolbar() {
        binding.toolbar.toVisible()
    }

    override fun hideToolbar() {
        binding.toolbar.toGone()
    }

    override fun setOnBackClickListener(listener: OnBackClickListener) {
        binding.toolbar.setOnBackClickListener(listener)
    }

    fun onUploadPhotoClick(item: MenuItem) {
        toast("${item.title}")
    }
}