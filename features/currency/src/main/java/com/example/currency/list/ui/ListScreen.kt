package com.example.currency.list.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.core.common_ui.ErrorScreen
import com.example.core.common_ui.LoadingScreen
import com.example.core.common_ui.UiState
import com.example.currency.list.CurrencyUi
import com.example.currency.list.ListViewModel

@Composable
fun ListScreen(modifier: Modifier, navController: NavController, viewModel: ListViewModel) {
    var base by rememberSaveable { mutableStateOf("USD") }
    ListToolbar(modifier, base) {
        base = it
        viewModel.fetchCurrencies()
    }
    viewModel.fetchCurrencies()
    val state = viewModel.uiState.collectAsState()
    when (val it = state.value) {
        is UiState.Content -> ListScreen(it.data, base) {  }
        is UiState.Error -> ErrorScreen(modifier) { viewModel.fetchCurrencies() }
        is UiState.Loading -> LoadingScreen()
    }
}

@Composable
fun ListScreen(
    currencies: List<CurrencyUi>, baseCurrency: String, onItemClick: (CurrencyUi) -> Unit
) {
    LazyColumn {
        items(currencies) { item ->
            CurrencyItem(item, baseCurrency) { onItemClick(item) }
        }
    }
}