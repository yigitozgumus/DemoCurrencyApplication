package com.yigitozgumus.domain.repositories

import com.yigitozgumus.api.models.Coin

interface MarketSearchRepository {
    suspend fun searchMarketFor(currency: String): List<Coin>
}
