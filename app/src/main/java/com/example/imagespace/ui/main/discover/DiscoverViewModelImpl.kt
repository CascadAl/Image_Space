package com.example.imagespace.ui.main.discover

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imagespace.network.ApiResponse
import com.example.imagespace.network.model.response.PhotoResponse
import com.example.imagespace.repository.discover.DiscoverRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DiscoverViewModelImpl @Inject constructor(
    private val repository: DiscoverRepository
) : ViewModel(), DiscoverViewModel {

    private val _uiState = MutableLiveData<DiscoverViewModel.UiState>()
    override val uiState: LiveData<DiscoverViewModel.UiState> = _uiState

    private val _error = MutableLiveData<String>()
    override val error: LiveData<String> = _error

    private val _newPhotos = MutableLiveData<List<PhotoResponse>>()
    override val newPhotos: LiveData<List<PhotoResponse>> = _newPhotos

    private val _popularPhotos = MutableLiveData<List<PhotoResponse>>()
    override val popularPhotos: LiveData<List<PhotoResponse>> = _popularPhotos

    init {
        getNewPhotos()
    }

    override fun getNewPhotos() {
        _uiState.postValue(DiscoverViewModel.UiState.Loading)
        viewModelScope.launch {
            when (val result = repository.getNewPhotos(1, 10)) {
                is ApiResponse.Error -> _uiState.postValue(DiscoverViewModel.UiState.Error(result.error))
                is ApiResponse.Success -> _uiState.postValue(DiscoverViewModel.UiState.Success)
            }
        }
    }

    override fun getPopularPhotos() {
        _uiState.postValue(DiscoverViewModel.UiState.Loading)
        viewModelScope.launch {
            when (val result = repository.getPopularPhotos(1, 10)) {
                is ApiResponse.Error -> _uiState.postValue(DiscoverViewModel.UiState.Error(result.error))
                is ApiResponse.Success -> _uiState.postValue(DiscoverViewModel.UiState.Success)
            }
        }
    }
}