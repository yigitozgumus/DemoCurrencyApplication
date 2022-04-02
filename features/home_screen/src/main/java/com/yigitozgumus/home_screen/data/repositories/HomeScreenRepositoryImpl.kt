/*
 * Created by yigitozgumus on 4/2/22, 11:44 AM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 4/2/22, 11:44 AM
 */

package com.yigitozgumus.home_screen.data.repositories

import com.yigitozgumus.api.services.AllCurrenciesService
import com.yigitozgumus.api.services.MarketSearchService
import com.yigitozgumus.home_screen.domain.model.CryptoCurrencyModel
import com.yigitozgumus.home_screen.domain.model.CurrencyModel
import com.yigitozgumus.home_screen.domain.repositories.HomeScreenRepository
import javax.inject.Inject

class HomeScreenRepositoryImpl @Inject constructor(
    private val currencyService: AllCurrenciesService,
    private val marketSearchService: MarketSearchService
) : HomeScreenRepository {

    override suspend fun getCurrencyTypes(): List<CurrencyModel> {
        return currencyService.getAllCurrencies().data.toList().map { CurrencyModel(it) }
    }

    override suspend fun getCryptoCurrencyList(currencyType: String): List<CryptoCurrencyModel> {
        return marketSearchService.searchMarket(currencyType).map { CryptoCurrencyModel(it) }
    }
}
