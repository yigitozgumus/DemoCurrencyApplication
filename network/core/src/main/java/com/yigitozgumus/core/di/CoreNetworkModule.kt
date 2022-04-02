/*
 * Created by yigitozgumus on 4/2/22, 11:44 AM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 4/2/22, 11:44 AM
 */

package com.yigitozgumus.core.di

import com.google.gson.GsonBuilder
import com.yigitozgumus.core.BuildConfig
import com.yigitozgumus.core.clients.*
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CoreNetworkModule {

    companion object {
        @Provides
        fun provideRetrofitBuilder(): Retrofit.Builder = Retrofit.Builder()

        @Provides
        @Singleton
        fun provideOkhttpClient(): OkHttpClient = OkHttpClient()

        @Provides
        @Singleton
        fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor? {
            return if (BuildConfig.DEBUG) {
                val loggingInterceptor = HttpLoggingInterceptor()
                loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                return loggingInterceptor
            } else null
        }

        @Provides
        fun provideGsonBuilder(): GsonBuilder = GsonBuilder()
    }

    @Binds
    @Singleton
    abstract fun bindOkhttpClient(impl: CurrencyOkhttpClient): OkhttpBuilder

    @Binds
    @Singleton
    @RetrofitTypeCoinBase
    abstract fun bindCoinBaseRetrofitClient(impl: CoinBaseRetrofitClient): RetrofitBuilder

    @Binds
    @Singleton
    @RetrofitTypeCoinGecko
    abstract fun bindCoinGecko(impl: CoinGeckoRetrofitClient): RetrofitBuilder

}
