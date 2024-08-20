package com.example.currency.list

data class CurrencyUi(
    val id: String,
    val name: String,
    val symbol: String,
    val image: String,
    val currentPrice: Double,
    val change: Double
)