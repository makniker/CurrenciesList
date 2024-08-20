package com.example.currency

import com.example.core.data.CurrencyRepository
import com.example.currency.list.CurrencyUi
import javax.inject.Inject

class GetListUseCase @Inject constructor(private val repository: CurrencyRepository) {
    suspend operator fun invoke(): Result<List<CurrencyUi>> {
        return repository.fetchCurrencyList().mapCatching { currencies ->
            currencies.map {
                CurrencyUi(
                    it.id,
                    it.name,
                    it.symbol,
                    it.image,
                    it.currentPrice,
                    it.priceChange24h
                )
            }
        }
    }
}