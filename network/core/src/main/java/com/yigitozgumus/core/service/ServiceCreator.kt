/*
 * Created by yigitozgumus on 4/2/22, 11:44 AM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 4/2/22, 11:44 AM
 */

package com.yigitozgumus.core.service

import javax.inject.Inject

interface ServiceCreator {
    fun <T> create(api: Class<T>): T
}


