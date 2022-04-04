/*
 * Created by yigitozgumus on 4/4/22, 10:16 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 4/4/22, 10:16 PM
 */

package com.yigitozgumus.democurrencyapplication.navigation

import androidx.fragment.app.Fragment

interface NavigatorDelegate {
    fun navigateTo(fragment: Fragment)
}
