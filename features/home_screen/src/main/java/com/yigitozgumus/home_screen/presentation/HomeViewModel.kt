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
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeScreenRepository: HomeScreenRepository
) : BaseViewModel() {

    private var currentCurrency: CurrencyModel? = null

    private val _currencyList = MutableSharedFlow<List<CurrencyModel>>()
    val currencies = _currencyList.asSharedFlow()

    val selectedCurrency: (CurrencyModel) -> Unit
    val currentCoinState: StateFlow<List<CryptoCurrencyListUiModel>>

    private var updateUiJob: Job? = null

    init {
        viewModelScope.launch {
            val currencyTypeList = homeScreenRepository.getCurrencyTypes()
            _currencyList.emit(currencyTypeList)
        }

        val nextSelectedCurrency = MutableSharedFlow<String>()
        selectedCurrency = { selectedCurrency ->
            currentCurrency = selectedCurrency
            viewModelScope.launch {
                updateUiJob?.cancel()
                nextSelectedCurrency.emit(selectedCurrency.id)
                updateUiJob = updateScreenContent()
            }
        }
        currentCoinState = nextSelectedCurrency.map {
            val coinList = homeScreenRepository.getCryptoCurrencyList(it)
            coinList.map { CryptoCurrencyListUiModel(it, currentCurrency?.id.toString()) }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = listOf()
        )
    }

    private fun updateScreenContent(): Job {
        return viewModelScope.launch(Dispatchers.IO) {
            while (isActive) {
                delay(5000L)
                currentCurrency?.let { selectedCurrency(it) }
            }
        }
    }
}

