package com.example.godsviking.ui.viewModel

import androidx.lifecycle.ViewModel
import com.example.godsviking.data.VikingUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class VikingViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(VikingUiState())
    val uiState: StateFlow<VikingUiState> = _uiState.asStateFlow()





}