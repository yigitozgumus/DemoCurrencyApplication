/*
 * Created by yigitozgumus on 4/2/22, 11:44 AM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 4/2/22, 11:44 AM
 */

package com.yigitozgumus.api.services

import com.yigitozgumus.api.models.Coin
import retrofit2.http.GET
import retrofit2.http.Query

interface MarketSearchService {
    @GET("coins/markets")
    suspend fun searchMarket(
        @Query("vs_currency") vsCurrency: String,
        @Query("order") order: String = "market_cap_desc",
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): List<Coin>
}
