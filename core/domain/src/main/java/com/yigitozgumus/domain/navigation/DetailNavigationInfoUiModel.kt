/*
 * Created by yigitozgumus on 4/5/22, 8:24 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 4/5/22, 8:24 PM
 */

package com.yigitozgumus.domain.navigation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailNavigationInfoUiModel(
    val coinName: String,
    val symbol: String,
    val coinImage: String,
    val highestPrice: Double,
    val lowestPrice: Double,
    val lastUpdatedTime: String,
    val currentCurrency: String
) : Parcelable, NavigationInfoUiModel
