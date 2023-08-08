package com.example.imagespace.ui.main.discover

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.imagespace.network.model.response.PhotoResponse
import com.example.imagespace.ui.main.discover.adapter.NewPhotoViewData
import kotlinx.coroutines.flow.Flow

interface DiscoverViewModel {

    sealed class UiState {
        object Loading: UiState()
        object Success: UiState()
        data class Error(val message: String): UiState()
    }

    val uiState: LiveData<UiState>
    val newPhotos: Flow<PagingData<NewPhotoViewData>>
    val popularPhotos: LiveData<List<PhotoResponse>>
    fun getPopularPhotos()
}