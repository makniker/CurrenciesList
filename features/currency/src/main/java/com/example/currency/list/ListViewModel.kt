package com.example.currency.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.common_ui.UiState
import com.example.currency.GetListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val getListUseCase: GetListUseCase): ViewModel() {
    private val _uiState = MutableStateFlow<UiState<List<CurrencyUi>>>(UiState.Loading())
    val uiState: StateFlow<UiState<List<CurrencyUi>>> = _uiState.asStateFlow()

    fun fetchCurrencies() {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.value =
                getListUseCase().fold(
                    onSuccess = { UiState.Content(it) },
                    onFailure = { UiState.Error(it.message ?: "") }
                )
        }
    }
}