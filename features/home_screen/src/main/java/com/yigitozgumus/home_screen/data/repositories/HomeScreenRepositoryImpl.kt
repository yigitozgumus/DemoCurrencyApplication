package com.yigitozgumus.home_screen.data.repositories

import com.yigitozgumus.api.services.AllCurrenciesService
import com.yigitozgumus.home_screen.domain.model.CurrencyUiModel
import com.yigitozgumus.home_screen.domain.repositories.HomeScreenRepository
import javax.inject.Inject

class HomeScreenRepositoryImpl @Inject constructor(
    private val currencyService: AllCurrenciesService
) : HomeScreenRepository {
    override suspend fun getAllCurrencies(): List<CurrencyUiModel> {
        return currencyService.getAllCurrencies().data.toList().map { CurrencyUiModel(it) }
    }
}
