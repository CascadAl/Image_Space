package com.example.imagespace.ui.main.discover

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.imagespace.api.PagingConstants
import com.example.imagespace.common.pagination.GenPagingSource
import com.example.imagespace.mapping.toNewPhotoData
import com.example.imagespace.network.ApiResponse
import com.example.imagespace.network.model.response.PhotoResponse
import com.example.imagespace.repository.discover.DiscoverRepository
import com.example.imagespace.ui.main.discover.adapter.NewPhotoViewData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DiscoverViewModelImpl @Inject constructor(
    private val repository: DiscoverRepository
) : ViewModel(), DiscoverViewModel {

    private val _uiState =
        MutableLiveData<DiscoverViewModel.UiState>(DiscoverViewModel.UiState.Loading)
    override val uiState: LiveData<DiscoverViewModel.UiState> = _uiState

    private val _popularPhotos = MutableLiveData<List<PhotoResponse>>()
    override val popularPhotos: LiveData<List<PhotoResponse>> = _popularPhotos

    override val newPhotos: Flow<PagingData<NewPhotoViewData>> =
        Pager(
            config = PagingConfig(
                pageSize = PagingConstants.PAGE_SIZE,
                initialLoadSize = PagingConstants.INITIAL_LOAD_SIZE,
                enablePlaceholders = true
            ),
            pagingSourceFactory = { GenPagingSource(this::getNewPhotos) }
        )
            .flow
            .cachedIn(viewModelScope)

    override fun getPopularPhotos() {
        _uiState.postValue(DiscoverViewModel.UiState.Loading)
        viewModelScope.launch {
            when (val result = repository.getPopularPhotos(1, 10)) {
                is ApiResponse.Error -> _uiState.postValue(DiscoverViewModel.UiState.Error(result.error))
                is ApiResponse.Success -> _uiState.postValue(DiscoverViewModel.UiState.Success)
            }
        }
    }

    private suspend fun getNewPhotos(page: Int, perPage: Int): List<NewPhotoViewData>? {
        when (val result = repository.getNewPhotos(page, perPage)) {
            is ApiResponse.Error -> _uiState.postValue(DiscoverViewModel.UiState.Error(result.error))
            is ApiResponse.Success -> {
                _uiState.postValue(DiscoverViewModel.UiState.Success)
                return result.data.map { it.toNewPhotoData() }
            }
        }

        return null
    }
}