package com.example.imagespace.ui.onboarding.registration

import com.example.imagespace.databinding.FragmentRegistrationBinding
import com.example.imagespace.ui.base.BaseUiFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegistrationFragment :
    BaseUiFragment<FragmentRegistrationBinding>(FragmentRegistrationBinding::inflate) {

    override fun initViews() {
        toolbar.showToolbar()

        binding.vFocus.requestFocus()
    }

    override fun initListeners() {
        toolbar.setOnBackClickListener { goBack() }
    }

    override fun onDestroy() {
        super.onDestroy()
        toolbar.hideToolbar()
    }
}