/*
 * Created by yigitozgumus on 4/2/22, 1:31 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 4/2/22, 1:31 PM
 */

package com.yigitozgumus.home_screen.presentation.coin

import androidx.annotation.StringRes
import com.yigitozgumus.home_screen.domain.model.CryptoCurrencyModel

sealed class CryptoCurrencyListUiModel

data class CryptoCurrencyListErrorUiModel(
    val currencyName: String,
    @StringRes val errorMessage: Int
) : CryptoCurrencyListUiModel()

data class CryptoCurrencyListContentUiModel(
    val name: String,
    val imageUrl: String,
    val currentPrice: Double,
    val currentCurrency: String,
) : CryptoCurrencyListUiModel() {
    constructor(model: CryptoCurrencyModel, currentCurrency: String) : this(
        name = model.name,
        imageUrl = model.coinImage,
        currentPrice = model.currentPrice,
        currentCurrency = currentCurrency
    )
}
