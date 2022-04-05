/*
 * Created by yigitozgumus on 4/5/22, 8:35 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 4/5/22, 8:35 PM
 */

package com.yigitozgumus.home_screen.domain.mapper

import com.yigitozgumus.domain.navigation.DetailNavigationInfoUiModel
import com.yigitozgumus.home_screen.presentation.coin.CryptoCurrencyListContentUiModel

class CurrencyDetailScreenMapper {
    fun mapToDetailUiModel(model: CryptoCurrencyListContentUiModel): DetailNavigationInfoUiModel {
        return DetailNavigationInfoUiModel(
            coinName = model.name,
            symbol = model.symbol,
            coinImage = model.imageUrl,
            highestPrice = model.highestPrice,
            lowestPrice = model.lowestPrice,
            lastUpdatedTime = model.lastUpdatedTime,
            currentCurrency = model.currentCurrency
        )
    }
}
