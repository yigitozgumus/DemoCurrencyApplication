package com.yigitozgumus.home_screen.presentation

import com.yigitozgumus.base_feature.base.BaseViewModel
import com.yigitozgumus.home_screen.domain.repositories.HomeScreenRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeScreenRepository: HomeScreenRepository
) : BaseViewModel() {
    // TODO implement the screen logic
}
