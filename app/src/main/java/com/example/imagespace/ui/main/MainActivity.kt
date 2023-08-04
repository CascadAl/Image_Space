package com.example.imagespace.ui.main

import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.fragment.NavHostFragment
import com.example.imagespace.R
import com.example.imagespace.databinding.ActivityMainBinding
import com.example.imagespace.extensions.toast
import com.example.imagespace.ui.base.BaseUiActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : BaseUiActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController

        binding.navView.setupWithNavController(navController)
    }

    fun onUploadPhotoClick(item: MenuItem) {
        toast("${item.title}")
    }
}