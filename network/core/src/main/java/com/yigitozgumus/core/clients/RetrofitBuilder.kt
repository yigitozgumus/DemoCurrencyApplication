/*
 * Created by yigitozgumus on 4/2/22, 11:44 AM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 4/2/22, 11:44 AM
 */

package com.yigitozgumus.core.clients

import retrofit2.Retrofit

interface RetrofitBuilder {
    val instance: Retrofit
    fun init(): Retrofit
}
