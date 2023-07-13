package com.example.imagespace.ui.onboarding

import android.os.Bundle
import com.example.imagespace.components.OnBackClickListener
import com.example.imagespace.components.ProgressLoader
import com.example.imagespace.components.ToolbarListener
import com.example.imagespace.components.ToolbarView
import com.example.imagespace.databinding.ActivityOnboardingBinding
import com.example.imagespace.extensions.toGone
import com.example.imagespace.extensions.toVisible
import com.example.imagespace.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardingActivity :
    BaseActivity<ActivityOnboardingBinding>(ActivityOnboardingBinding::inflate),
    ProgressLoader,
    ToolbarListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.progress.setWindow(window)
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
}