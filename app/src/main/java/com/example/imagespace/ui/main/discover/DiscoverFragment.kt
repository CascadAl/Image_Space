package com.example.imagespace.ui.main.discover

import androidx.fragment.app.viewModels
import com.example.imagespace.components.ProgressLoader
import com.example.imagespace.databinding.FragmentDiscoverBinding
import com.example.imagespace.extensions.toast
import com.example.imagespace.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DiscoverFragment : BaseFragment<FragmentDiscoverBinding>(FragmentDiscoverBinding::inflate) {

    private val viewModel: DiscoverViewModel by viewModels<DiscoverViewModelImpl>()

    private val progress: ProgressLoader by lazy { activity as ProgressLoader }

    override fun initObservers() {
        viewModel.uiState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is DiscoverViewModel.UiState.Error -> {
                    progress.hideLoader()
                    toast(state.message)
                }
                DiscoverViewModel.UiState.Loading -> {
                    progress.showLoader()
                }
                DiscoverViewModel.UiState.Success -> {
                    progress.hideLoader()
                    toast("Success")
                }
            }
        }
    }
}