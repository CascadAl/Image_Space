package com.example.imagespace.ui.onboarding

import com.example.imagespace.databinding.FragmentOnboardingBinding
import com.example.imagespace.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardingFragment :
    BaseFragment<FragmentOnboardingBinding>(FragmentOnboardingBinding::inflate) {
    override fun initListeners() = with(binding) {
        tvTitle.setOnClickListener {
            navigate(OnboardingFragmentDirections.showRegistration())
        }
    }
}