/*
 * Created by yigitozgumus on 4/2/22, 1:31 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 4/2/22, 1:31 PM
 */

package com.yigitozgumus.home_screen.presentation.coin

import com.yigitozgumus.home_screen.domain.model.CryptoCurrencyModel

data class CryptoCurrencyListUiModel(
    val name: String
) {
    constructor(model: CryptoCurrencyModel) : this(
        name = model.name
    )
}
