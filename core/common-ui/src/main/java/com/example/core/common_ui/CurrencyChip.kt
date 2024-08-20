package com.example.core.common_ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.common_ui.theme.Typography
import com.example.core.common_ui.theme.main
import com.example.core.common_ui.theme.mainVariant

@Composable
fun CurrencyChip(label: String, selected: Boolean, onChipButtonPressed: (String) -> Unit) {
    FilterChip(modifier = Modifier.padding(horizontal = 8.dp),
        selected = true,
        label = { Text(label, style = Typography.labelSmall) },
        onClick = { onChipButtonPressed(label) },
        shape = RoundedCornerShape(20.dp),
        colors = FilterChipDefaults.filterChipColors(
            containerColor = if (selected) Color.Black else mainVariant,
            iconColor = Color.White,
            labelColor = Color.White,
            selectedContainerColor = if (selected) main.copy(0.12f) else Color.Black.copy(0.12f),
            selectedLabelColor = if (selected) mainVariant else Color.Black.copy(0.87f),
            selectedLeadingIconColor = Color.Black
        )
    )
}

@Composable
@Preview(showBackground = true)
fun CurrencyChipPreview() {
    Column {
    CurrencyChip("USD", true) {}
        CurrencyChip("USD", false) {}
    }
}