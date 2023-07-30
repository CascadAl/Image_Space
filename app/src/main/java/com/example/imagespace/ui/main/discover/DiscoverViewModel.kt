package com.example.imagespace.ui.main.discover

import androidx.lifecycle.LiveData
import com.example.imagespace.network.model.response.PhotoResponse

interface DiscoverViewModel {

    sealed class UiState {
        object Loading: UiState()
        object Success: UiState()
        data class Error(val message: String): UiState()
    }

    val uiState: LiveData<UiState>
    val error: LiveData<String>
    val newPhotos: LiveData<List<PhotoResponse>>
    val popularPhotos: LiveData<List<PhotoResponse>>

    fun getNewPhotos()
    fun getPopularPhotos()
}