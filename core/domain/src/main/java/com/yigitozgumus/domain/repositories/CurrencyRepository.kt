package com.yigitozgumus.domain.repositories

import com.yigitozgumus.api.models.CurrencyListResponse

interface CurrencyRepository {
    suspend fun getCurrencyData(): CurrencyListResponse
}
