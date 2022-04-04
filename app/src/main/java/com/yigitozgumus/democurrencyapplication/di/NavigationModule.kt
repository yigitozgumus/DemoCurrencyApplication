/*
 * Created by yigitozgumus on 4/4/22, 10:43 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 4/4/22, 10:43 PM
 */

package com.yigitozgumus.democurrencyapplication.di

import com.yigitozgumus.democurrencyapplication.navigation.CoinInteractionOwnerImpl
import com.yigitozgumus.home_screen.domain.navigation.CoinInteractionOwner
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class NavigationModule {

    @Binds
    abstract fun bindCoinInteractionOwner(impl: CoinInteractionOwnerImpl): CoinInteractionOwner
}
