package com.example.currency.details.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.common_ui.ShadowImitation
import com.example.core.common_ui.theme.CurrencyListTheme
import com.example.core.common_ui.theme.Typography

@Composable
fun DetailsToolbar(modifier: Modifier = Modifier, title: String, onBackButtonPressed: () -> Unit) {
    Row(
        modifier = modifier.fillMaxWidth(),

        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            ShadowImitation(modifier, 0.2f, 0.6f, 2)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier.clickable { onBackButtonPressed() }) {
                    Icon(
                        modifier = modifier
                            .padding(16.dp)
                            .size(24.dp),
                        painter = painterResource(com.example.core.common_ui.R.drawable.sharp_arrow_back_24),
                        contentDescription = "Back arrow"
                    )
                }
                Text(
                    text = title,
                    style = Typography.titleLarge,
                    modifier = Modifier
                        .weight(1f)
                        .alpha(0.87f)
                )
            }
            ShadowImitation(modifier, 0.6f, 0.0f, 4)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsToolbarPreview() {
    CurrencyListTheme {
        DetailsToolbar(title = "Bitcoin", onBackButtonPressed = {})
    }
}
