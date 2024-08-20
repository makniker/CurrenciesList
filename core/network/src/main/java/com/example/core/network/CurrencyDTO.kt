package com.example.core.network

import com.google.gson.annotations.SerializedName

data class CurrencyDTO(
    @SerializedName("id") val id: String,
    @SerializedName("symbol") val symbol: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: String,
    @SerializedName("current_price") val currentPrice: Double,
    @SerializedName("price_change_24h") val priceChange24h: Double,
)