package com.example.currency.list.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.core.common_ui.theme.Typography
import com.example.core.common_ui.theme.coinHead
import com.example.core.common_ui.theme.coinSymbol
import com.example.currency.R
import com.example.currency.list.CurrencyUi
import java.text.NumberFormat
import java.util.Locale

@Composable
fun CurrencyItem(item: CurrencyUi, baseCurrency: String, onClick: (String) -> Unit) {
    Box(modifier = Modifier
        .clickable { onClick(item.id) }
        .fillMaxWidth()) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(intrinsicSize = IntrinsicSize.Max)
                .padding(8.dp)
        ) {
            AsyncImage(
                model = item.image, contentDescription = null, modifier = Modifier.size(40.dp)
            )
            Spacer(Modifier.padding(end = 8.dp))
            Column {
                Text(
                    text = item.name,
                    textAlign = TextAlign.Start,
                    style = Typography.bodyMedium,
                    color = coinHead
                )
                Spacer(Modifier.weight(1f))
                Text(
                    text = item.symbol.uppercase(),
                    textAlign = TextAlign.Start,
                    style = Typography.bodySmall,
                    color = coinSymbol
                )
            }
            Spacer(Modifier.weight(1f))
            Column(horizontalAlignment = Alignment.End) {
                val numberFormat = NumberFormat.getNumberInstance(Locale.US)
                numberFormat.maximumFractionDigits = 2
                val formattedNumber = numberFormat.format(item.currentPrice)
                Text(
                    text = stringResource(R.string.currency_value, baseCurrency, formattedNumber),
                    textAlign = TextAlign.End,
                    style = Typography.bodyMedium,
                    color = coinHead
                )
                Spacer(Modifier.weight(1f))
                Text(
                    text = stringResource(R.string.currency_grow, item.change),
                    textAlign = TextAlign.End,
                    style = Typography.bodySmall,
                    color = if (item.change >= 0) Color.Green else Color.Red
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CurrencyItemPreview() {
    CurrencyItem(CurrencyUi(
        "btc",
        "Bitcoin",
        "btc",
        "https://assets.coingecko.com/coins/images/1/large/bitcoin.png?1696501400",
        770187.66,
        -4.77063
    ), "$"
    ) {}
}