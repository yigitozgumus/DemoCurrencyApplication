package com.yigitozgumus.home_screen.domain.model

import com.yigitozgumus.api.models.Currency

data class CurrencyUiModel(
    val name: String
) {
    constructor(currency: Currency) : this(
        name = currency.name.orEmpty()
    )
}
