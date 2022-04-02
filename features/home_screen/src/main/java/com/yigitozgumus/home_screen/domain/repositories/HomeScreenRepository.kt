/*
 * Created by yigitozgumus on 4/2/22, 11:44 AM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 4/2/22, 11:44 AM
 */

package com.yigitozgumus.home_screen.domain.repositories

import com.yigitozgumus.home_screen.domain.model.CryptoCurrencyModel
import com.yigitozgumus.home_screen.domain.model.CurrencyModel

interface HomeScreenRepository {

    suspend fun getCurrencyTypes(): List<CurrencyModel>

    suspend fun getCryptoCurrencyList(currencyType: String): List<CryptoCurrencyModel>
}
