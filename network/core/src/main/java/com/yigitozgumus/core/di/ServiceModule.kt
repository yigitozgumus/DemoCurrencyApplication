package com.yigitozgumus.core.di

import com.yigitozgumus.core.service.*
import dagger.Binds
import dagger.Module
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
}
