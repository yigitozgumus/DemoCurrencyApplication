/*
 * Created by yigitozgumus on 4/2/22, 11:44 AM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 4/2/22, 11:44 AM
 */

package com.yigitozgumus.api.services

import com.yigitozgumus.api.models.CurrencyListResponse
import retrofit2.http.GET

interface AllCurrenciesService {

    @GET("currencies")
    suspend fun getAllCurrencies(): CurrencyListResponse
}
