/*
 * Created by yigitozgumus on 4/2/22, 1:30 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 4/2/22, 1:30 PM
 */

package com.yigitozgumus.home_screen.presentation.coin

import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.text.color
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.yigitozgumus.home_screen.R
import com.yigitozgumus.home_screen.databinding.LayoutCryptoCurrencyListItemBinding
import com.yigitozgumus.home_screen.databinding.LayoutHomeScreenErrorBinding

abstract class CryptoCurrencyListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(model: CryptoCurrencyListUiModel)
}

class CryptoCurrencyListContentViewHolder(
    parent: ViewGroup,
    private val binding: LayoutCryptoCurrencyListItemBinding = LayoutCryptoCurrencyListItemBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false
    )
) : CryptoCurrencyListViewHolder(binding.root) {

    override fun bind(model: CryptoCurrencyListUiModel) {
        with(model as CryptoCurrencyListContentUiModel) {
            binding.coinName.text = model.name
            binding.coinImage.load(model.imageUrl)
            binding.currentPriceAmount.text = "${model.currentPrice} ${model.currentCurrency.uppercase()}"
        }
    }
}

class CryptoCurrencyListErrorViewHolder(
    private val parent: ViewGroup,
    private val binding: LayoutHomeScreenErrorBinding = LayoutHomeScreenErrorBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false
    )
) : CryptoCurrencyListViewHolder(binding.root) {
    override fun bind(model: CryptoCurrencyListUiModel) {
        with(model as CryptoCurrencyListErrorUiModel) {
            binding.errorTitle.text = SpannableStringBuilder()
                .color(ContextCompat.getColor(parent.context, R.color.black)) { append(model.currencyName) }
                .append(" ")
                .append(parent.context.getString(model.errorMessage))
        }
    }

}
