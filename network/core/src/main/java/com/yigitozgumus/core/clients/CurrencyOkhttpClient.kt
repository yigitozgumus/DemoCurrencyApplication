/*
 * Created by yigitozgumus on 4/2/22, 11:44 AM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 4/2/22, 11:44 AM
 */

package com.yigitozgumus.core.clients

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class CurrencyOkhttpClient @Inject constructor(
    private val okHttpClient: OkHttpClient,
    private val loggingInterceptor: HttpLoggingInterceptor?
) : OkhttpBuilder {
    override val instance: OkHttpClient.Builder by lazy { init() }

    override fun init(): OkHttpClient.Builder = okHttpClient.newBuilder().apply {
        loggingInterceptor?.let {
            addInterceptor(it)
        }
    }

}
