/*
 * Created by yigitozgumus on 4/2/22, 11:44 AM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 4/2/22, 11:44 AM
 */

package com.yigitozgumus.core.service

import com.yigitozgumus.core.clients.RetrofitBuilder
import com.yigitozgumus.core.di.RetrofitTypeCoinGecko
import javax.inject.Inject

@ServiceTypeCoinGecko
class CoinGeckoService @Inject constructor(
    @RetrofitTypeCoinGecko private val retrofit: RetrofitBuilder
) : ServiceCreator {
    override fun <T> create(api: Class<T>): T {
        return retrofit.instance.create(api)
    }
}
