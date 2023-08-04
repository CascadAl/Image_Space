package com.example.imagespace.ui.onboarding

import android.os.Bundle
import com.example.imagespace.databinding.ActivityOnboardingBinding
import com.example.imagespace.ui.base.BaseUiActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardingActivity :
    BaseUiActivity<ActivityOnboardingBinding>(ActivityOnboardingBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.progress.setWindow(window)
    }
}