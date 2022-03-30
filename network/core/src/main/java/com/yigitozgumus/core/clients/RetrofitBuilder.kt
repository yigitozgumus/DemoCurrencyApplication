package com.yigitozgumus.core.clients

import retrofit2.Retrofit

interface RetrofitBuilder {
    val instance: Retrofit
    fun init(): Retrofit
}
