package com.example.imagespace.ui.main.discover

import androidx.fragment.app.viewModels
import com.example.imagespace.R
import com.example.imagespace.common.GenRecyclerAdapter
import com.example.imagespace.components.ProgressLoader
import com.example.imagespace.databinding.FragmentDiscoverBinding
import com.example.imagespace.extensions.toast
import com.example.imagespace.ui.base.BaseFragment
import com.example.imagespace.ui.main.discover.adapter.NewPhotoData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DiscoverFragment : BaseFragment<FragmentDiscoverBinding>(FragmentDiscoverBinding::inflate) {

    private val viewModel: DiscoverViewModel by viewModels<DiscoverViewModelImpl>()

    private val progress: ProgressLoader by lazy { activity as ProgressLoader }

    private val newPhotoAdapter: GenRecyclerAdapter<NewPhotoData> by lazy {
        GenRecyclerAdapter(R.layout.item_new_photo)
    }

    override fun initViews() = with(binding) {
        rvNewPhotos.adapter = newPhotoAdapter
    }

    override fun initObservers() = with(binding) {
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

        viewModel.newPhotos.observe(viewLifecycleOwner) {
            newPhotoAdapter.submitList(it)
        }
    }
}