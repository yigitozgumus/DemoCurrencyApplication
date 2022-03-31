package com.yigitozgumus.home_screen.domain.repositories

import com.yigitozgumus.home_screen.domain.model.CurrencyUiModel

interface HomeScreenRepository {
    suspend fun getAllCurrencies(): List<CurrencyUiModel>
}
