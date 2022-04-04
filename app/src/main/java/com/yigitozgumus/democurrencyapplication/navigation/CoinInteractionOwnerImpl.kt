/*
 * Created by yigitozgumus on 4/4/22, 10:40 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 4/4/22, 10:40 PM
 */

package com.yigitozgumus.democurrencyapplication.navigation

import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit
import com.yigitozgumus.democurrencyapplication.R
import com.yigitozgumus.detail_screen.presentation.DetailFragment
import com.yigitozgumus.home_screen.domain.navigation.CoinInteractionOwner
import javax.inject.Inject

class CoinInteractionOwnerImpl @Inject constructor(
    private val activity: FragmentActivity
) : CoinInteractionOwner {
    override fun goToDetailScreen(coinName: String) {
        activity.supportFragmentManager.commit {
            replace(R.id.fragment_container, DetailFragment())
            addToBackStack(null)
            setReorderingAllowed(true)
        }
    }

}
