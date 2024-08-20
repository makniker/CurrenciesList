package com.example.currency.list.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.common_ui.CurrencyChip
import com.example.core.common_ui.ShadowImitation
import com.example.core.common_ui.theme.CurrencyListTheme
import com.example.core.common_ui.theme.Typography
import com.example.currency.R

@Composable
fun ListToolbar(modifier: Modifier = Modifier, selectedCurrency: String, onChipButtonPressed: (String) -> Unit) {
    Column(modifier.fillMaxWidth()) {
        Text(
            text = stringResource(R.string.currency_list),
            style = Typography.titleLarge,
            modifier = Modifier
                .alpha(0.87f)
                .padding(16.dp)
        )
        Row(modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp)) {
            val list = listOf("USD", "RUB")
            CurrencyChip(list[0], list[0] == selectedCurrency) {onChipButtonPressed(list[0]) }
            CurrencyChip(list[1], list[1] == selectedCurrency) {onChipButtonPressed(list[1]) }

        }
        ShadowImitation(modifier, 0.6f, 0.0f, 4)
    }
}

@Preview(showBackground = true)
@Composable
fun ListToolbarPreview() {
    CurrencyListTheme {
        ListToolbar(onChipButtonPressed = {}, selectedCurrency = "USD")
    }
}