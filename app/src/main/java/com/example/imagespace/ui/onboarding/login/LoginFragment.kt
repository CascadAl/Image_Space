package com.example.imagespace.ui.onboarding.login

import com.example.imagespace.databinding.FragmentLoginBinding
import com.example.imagespace.ui.base.BaseUiFragment
import com.example.imagespace.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseUiFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    override fun initViews() {
        toolbar.showToolbar()
    }

    override fun initListeners() = with(binding) {
        toolbar.setOnBackClickListener { goBack() }
        btnNext.setOnClickListener { navigateTo(MainActivity::class.java) }
    }

    override fun onDestroy() {
        super.onDestroy()
        toolbar.hideToolbar()
    }
}