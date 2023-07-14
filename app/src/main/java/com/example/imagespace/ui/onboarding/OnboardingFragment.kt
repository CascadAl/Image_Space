package com.example.imagespace.ui.onboarding

import com.example.imagespace.databinding.FragmentOnboardingBinding
import com.example.imagespace.extensions.hideStatusBar
import com.example.imagespace.extensions.showStatusBar
import com.example.imagespace.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardingFragment :
    BaseFragment<FragmentOnboardingBinding>(FragmentOnboardingBinding::inflate) {

    override fun initViews() {
        super.initViews()
        hideStatusBar()
    }

    override fun initListeners() = with(binding) {
        btnLogin.setOnClickListener {
            navigate(OnboardingFragmentDirections.showLogin())
        }

        btnRegister.setOnClickListener {
            navigate(OnboardingFragmentDirections.showRegistration())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        showStatusBar()
    }
}