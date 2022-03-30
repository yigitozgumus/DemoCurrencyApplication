package com.yigitozgumus.api.services

import com.yigitozgumus.api.models.CurrencyListResponse
import retrofit2.http.GET

interface AllCurrenciesService {

    @GET("currencies")
    suspend fun getAllCurrencies(): CurrencyListResponse
}
