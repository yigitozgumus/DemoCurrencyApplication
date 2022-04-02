/*
 * Created by yigitozgumus on 4/2/22, 11:44 AM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 4/2/22, 11:44 AM
 */

package com.yigitozgumus.core.di

import com.yigitozgumus.api.services.AllCurrenciesService
import com.yigitozgumus.api.services.MarketSearchService
import com.yigitozgumus.core.service.*
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceModule {

    @Binds
    @Singleton
    @ServiceTypeCoinBase
    abstract fun bindCoinBaseService(impl: CoinBaseService): ServiceCreator

    @Binds
    @Singleton
    @ServiceTypeCoinGecko
    abstract fun bindCoinGeckoService(impl: CoinGeckoService): ServiceCreator

    companion object {
        @Provides
        @Singleton
        fun provideAllCurrenciesService(factory: CoinBaseService): AllCurrenciesService =
            factory.create(AllCurrenciesService::class.java)

        @Provides
        @Singleton
        fun provideMarketSearchService(factory: CoinGeckoService): MarketSearchService =
            factory.create(MarketSearchService::class.java)
    }
}
