package com.example.imagespace.ui.onboarding.registration

import com.example.imagespace.components.ToolbarListener
import com.example.imagespace.databinding.FragmentRegistrationBinding
import com.example.imagespace.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegistrationFragment :
    BaseFragment<FragmentRegistrationBinding>(FragmentRegistrationBinding::inflate) {

    private val toolbar: ToolbarListener by lazy { activity as ToolbarListener }

    override fun initViews() {
        toolbar.showToolbar()
    }

    override fun initListeners() {
        toolbar.setOnBackClickListener { goBack() }
    }

    override fun onDestroy() {
        super.onDestroy()
        toolbar.hideToolbar()
    }
}