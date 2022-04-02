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
    val coinImage: String
) {
    constructor(response: Coin) : this(
        id = response.id.orEmpty(),
        name = response.name.orEmpty(),
        symbol = response.symbol.orEmpty(),
        coinImage = response.image.orEmpty()
    )
}
