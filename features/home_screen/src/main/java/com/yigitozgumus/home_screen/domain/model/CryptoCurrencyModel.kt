/*
 * Created by yigitozgumus on 4/2/22, 11:44 AM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 4/2/22, 11:44 AM
 */

package com.yigitozgumus.home_screen.domain.model

import com.yigitozgumus.api.models.Coin

data class CryptoCurrencyModel(
    val id: String,
    val symbol: String,
    val name: String,
    val coinImage: String,
    val currentPrice: Double,
    val highestPrice: Double,
    val lowestPrice: Double,
    val lastUpdateTime: String,

    ) {
    constructor(response: Coin) : this(
        id = response.id.orEmpty(),
        name = response.name.orEmpty(),
        symbol = response.symbol.orEmpty(),
        coinImage = response.image.orEmpty(),
        currentPrice = response.currentPrice ?: 0.0,
        highestPrice = response.high24h ?: 0.0,
        lowestPrice = response.low24h ?: 0.0,
        lastUpdateTime = response.lastUpdated.orEmpty()
    )
}
