package com.example.imagespace.ui.onboarding

import android.os.Bundle
import com.example.imagespace.components.ProgressLoader
import com.example.imagespace.databinding.ActivityOnboardingBinding
import com.example.imagespace.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardingActivity :
    BaseActivity<ActivityOnboardingBinding>(ActivityOnboardingBinding::inflate),
    ProgressLoader {

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
}