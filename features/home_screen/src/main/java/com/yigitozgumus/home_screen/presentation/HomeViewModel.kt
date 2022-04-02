/*
 * Created by yigitozgumus on 4/2/22, 11:44 AM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 4/2/22, 11:44 AM
 */

package com.yigitozgumus.home_screen.presentation

import androidx.lifecycle.viewModelScope
import com.yigitozgumus.base_feature.base.BaseViewModel
import com.yigitozgumus.home_screen.domain.model.CurrencyModel
import com.yigitozgumus.home_screen.domain.repositories.HomeScreenRepository
import com.yigitozgumus.home_screen.presentation.coin.CryptoCurrencyListUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeScreenRepository: HomeScreenRepository
) : BaseViewModel() {

    private var currentCurrency: String? = null

    private val _currencyList = MutableSharedFlow<List<CurrencyModel>>()
    val currencies = _currencyList.asSharedFlow()
    
    val selectedCurrency: (CurrencyModel) -> Unit
    val currentCoinState: StateFlow<List<CryptoCurrencyListUiModel>>

    init {
        viewModelScope.launch {
            val currencyTypeList = homeScreenRepository.getCurrencyTypes()
            _currencyList.emit(currencyTypeList)
        }

        val nextSelectedCurrency = MutableSharedFlow<String>()
        selectedCurrency = { selectedCurrency ->
            currentCurrency = selectedCurrency.id
            viewModelScope.launch {
                nextSelectedCurrency.emit(selectedCurrency.id)
            }
        }
        currentCoinState = nextSelectedCurrency.map {
            val coinList = homeScreenRepository.getCryptoCurrencyList(it)
            coinList.map { CryptoCurrencyListUiModel(it, currentCurrency.toString()) }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = listOf()
        )
    }
}

