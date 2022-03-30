package com.yigitozgumus.core.service

import javax.inject.Inject

interface ServiceCreator {
    fun <T> create(api: Class<T>): T
}


