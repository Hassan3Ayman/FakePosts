package com.hassan.fakeposts.presentation.viewmodel.details

import android.hardware.camera2.CameraExtensionSession.StillCaptureLatency
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hassan.fakeposts.domain.usecase.ManagePostUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val managePost: ManagePostUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel(){

    val postId: String = savedStateHandle.get<String>("postId") ?: "1"
    private val _state = MutableStateFlow(DetailsUiState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                _state.update {
                    it.copy(
                        isLoading = false,
                        post = managePost.getPostById(postId).toPostDetailsUiState()
                    )
                }
            } catch (e: Exception) {
                _state.update { it.copy(isLoading = false, isError = true) }
            }
        }
    }
}