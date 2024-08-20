package com.example.core.data

import com.example.core.network.CurrencyDTO

interface CurrencyRepository {
    suspend fun fetchCurrencyList():Result<List<CurrencyDTO>>
}