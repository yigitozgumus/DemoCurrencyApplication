/*
 * Created by yigitozgumus on 4/2/22, 1:30 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 4/2/22, 1:30 PM
 */

package com.yigitozgumus.home_screen.presentation.coin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.yigitozgumus.home_screen.databinding.LayoutCryptoCurrencyListItemBinding

class CryptoCurrencyListViewHolder(
    parent: ViewGroup,
    private val binding: LayoutCryptoCurrencyListItemBinding = LayoutCryptoCurrencyListItemBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false
    )
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(model: CryptoCurrencyListUiModel) {
        binding.coinName.text = model.name
        binding.coinImage.load(model.imageUrl)
        binding.currentPriceAmount.text = "${model.currentPrice} ${model.currentCurrency.uppercase()}"
    }
}
