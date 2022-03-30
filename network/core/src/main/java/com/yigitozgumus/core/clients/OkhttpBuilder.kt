package com.yigitozgumus.core.clients

import okhttp3.OkHttpClient

interface OkhttpBuilder {
    val instance: OkHttpClient.Builder
    fun init(): OkHttpClient.Builder
}
