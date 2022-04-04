/*
 * Created by yigitozgumus on 4/2/22, 11:44 AM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 4/2/22, 11:44 AM
 */

package com.yigitozgumus.home_screen.presentation

import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.yigitozgumus.base_feature.base.BaseFragment
import com.yigitozgumus.base_feature.content.BindingInflater
import com.yigitozgumus.home_screen.R
import com.yigitozgumus.home_screen.databinding.FragmentHomeBinding
import com.yigitozgumus.home_screen.domain.model.CurrencyModel
import com.yigitozgumus.home_screen.presentation.coin.CryptoCurrencyListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment(), CurrencySelectionOwner {

    override val viewModel: HomeViewModel by viewModels()

    private val coinListAdapter by lazy { CryptoCurrencyListAdapter() }

    private var localCurrencyList: List<CurrencyModel> = listOf()

    override val bindingInflater = BindingInflater(FragmentHomeBinding::inflate) {
        initCurrencySelectorArea()
        initCoinListArea()
    }

    private fun FragmentHomeBinding.initCoinListArea() {
        homeScreenCurrencyListRecyclerview.adapter = coinListAdapter
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.currentCoinState.collect {
                when (it) {
                    is ScreenUiState.Content -> coinListAdapter.submitList(it.data)
                    is ScreenUiState.Error -> {
                        coinListAdapter.submitList(listOf(it.errorModel))
                    }
                }
            }
        }
    }

    private fun FragmentHomeBinding.initCurrencySelectorArea() {
        homeScreenCurrencySelector.onItemSelectedListener = this@HomeFragment
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.currencies.collect { currencyTypeList ->
                localCurrencyList = currencyTypeList
                homeScreenCurrencySelector.adapter = ArrayAdapter<Any?>(
                    requireContext(), R.layout.layout_dropdown_item, currencyTypeList.map { it.name }
                )
                viewModel.selectedCurrency(currencyTypeList.first())
            }
        }
    }

    override fun onCurrencySelected(currency: String) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.selectedCurrency(localCurrencyList.first { it.name == currency })
        }
    }

}
