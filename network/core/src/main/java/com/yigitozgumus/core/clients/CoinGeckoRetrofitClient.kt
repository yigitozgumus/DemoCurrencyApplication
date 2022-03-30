package com.yigitozgumus.core.clients

import COINGECKO_BASE_URL
import com.google.gson.GsonBuilder
import com.yigitozgumus.core.di.RetrofitTypeCoinGecko
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@RetrofitTypeCoinGecko
class CoinGeckoRetrofitClient @Inject constructor(
    private val retrofitBuilder: Retrofit.Builder,
    private val okhttpBuilder: OkhttpBuilder,
    private val gsonBuilder: GsonBuilder,
) : RetrofitBuilder {
    override val instance: Retrofit by lazy { init() }

    override fun init(): Retrofit {
        retrofitBuilder.addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))
        return retrofitBuilder
            .baseUrl(COINGECKO_BASE_URL).client(okhttpBuilder.instance.build())
            .build()
    }
}
