package com.example.imagespace.ui.main.discover

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.imagespace.R
import com.example.imagespace.common.pagination.GenPagingAdapter
import com.example.imagespace.databinding.FragmentDiscoverBinding
import com.example.imagespace.extensions.toast
import com.example.imagespace.ui.base.BaseUiFragment
import com.example.imagespace.ui.main.discover.adapter.NewPhotoViewData
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DiscoverFragment : BaseUiFragment<FragmentDiscoverBinding>(FragmentDiscoverBinding::inflate) {

    private val viewModel: DiscoverViewModel by viewModels<DiscoverViewModelImpl>()

    private val newPhotoAdapter: GenPagingAdapter<NewPhotoViewData> by lazy {
        GenPagingAdapter(R.layout.item_new_photo)
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
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.newPhotos.collectLatest {
                newPhotoAdapter.submitData(it)
            }
        }

        Unit
    }
}