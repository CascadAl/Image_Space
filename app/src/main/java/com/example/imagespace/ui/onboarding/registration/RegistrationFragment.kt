package com.example.imagespace.ui.onboarding.registration

import android.widget.EditText
import com.example.imagespace.components.ToolbarListener
import com.example.imagespace.databinding.FragmentRegistrationBinding
import com.example.imagespace.extensions.toast
import com.example.imagespace.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegistrationFragment :
    BaseFragment<FragmentRegistrationBinding>(FragmentRegistrationBinding::inflate) {

    private val toolbar: ToolbarListener by lazy { activity as ToolbarListener }

    override fun initViews() {
        toolbar.showToolbar()

        binding.vFocus.requestFocus()
    }

    override fun initListeners() {
        toolbar.setOnBackClickListener { goBack() }

        activity?.currentFocus?.let {
            if (it !is EditText) {
                toast("Click")
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        toolbar.hideToolbar()
    }
}