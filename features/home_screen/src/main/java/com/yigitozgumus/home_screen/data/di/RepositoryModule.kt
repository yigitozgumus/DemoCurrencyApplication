/*
 * Created by yigitozgumus on 4/2/22, 11:44 AM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 4/2/22, 11:44 AM
 */

package com.yigitozgumus.home_screen.data.di

import com.yigitozgumus.home_screen.data.repositories.HomeScreenRepositoryImpl
import com.yigitozgumus.home_screen.domain.repositories.HomeScreenRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindHomeScreenRepository(impl: HomeScreenRepositoryImpl): HomeScreenRepository
}
