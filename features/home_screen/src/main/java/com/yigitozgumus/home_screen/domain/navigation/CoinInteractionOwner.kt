/*
 * Created by yigitozgumus on 4/4/22, 10:39 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 4/4/22, 10:39 PM
 */

package com.yigitozgumus.home_screen.domain.navigation

import com.yigitozgumus.domain.navigation.DetailNavigationInfoUiModel

interface CoinInteractionOwner {
    fun goToDetailScreen(uiModel: DetailNavigationInfoUiModel)
}
