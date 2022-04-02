/*
 * Created by yigitozgumus on 4/2/22, 11:44 AM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 4/2/22, 11:44 AM
 */

package com.yigitozgumus.home_screen.domain.model

import com.yigitozgumus.api.models.Currency

data class CurrencyModel(
    val id: String,
    val name: String
) {
    constructor(currency: Currency) : this(
        id = currency.id.orEmpty().lowercase(),
        name = currency.name.orEmpty()
    )
}
