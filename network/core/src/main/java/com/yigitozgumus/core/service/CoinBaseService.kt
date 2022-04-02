/*
 * Created by yigitozgumus on 4/2/22, 11:44 AM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 4/2/22, 11:44 AM
 */

package com.yigitozgumus.core.service

import com.yigitozgumus.core.clients.RetrofitBuilder
import com.yigitozgumus.core.di.RetrofitTypeCoinBase
import javax.inject.Inject

@ServiceTypeCoinBase
class CoinBaseService @Inject constructor(
    @RetrofitTypeCoinBase private val retrofit: RetrofitBuilder
) : ServiceCreator {
    override fun <T> create(api: Class<T>): T {
        return retrofit.instance.create(api)
    }
}
