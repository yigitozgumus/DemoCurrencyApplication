/*
 * Created by yigitozgumus on 4/2/22, 11:44 AM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 4/2/22, 11:44 AM
 */

package com.yigitozgumus.core.clients

import COINBASE_BASE_URL
import com.google.gson.GsonBuilder
import com.yigitozgumus.core.di.RetrofitTypeCoinBase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@RetrofitTypeCoinBase
class CoinBaseRetrofitClient @Inject constructor(
    private val retrofitBuilder: Retrofit.Builder,
    private val okhttpBuilder: OkhttpBuilder,
    private val gsonBuilder: GsonBuilder,
) : RetrofitBuilder {
    override val instance: Retrofit by lazy { init() }

    override fun init(): Retrofit {
        retrofitBuilder.addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))
        return retrofitBuilder
            .baseUrl(COINBASE_BASE_URL).client(okhttpBuilder.instance.build())
            .build()
    }
}
