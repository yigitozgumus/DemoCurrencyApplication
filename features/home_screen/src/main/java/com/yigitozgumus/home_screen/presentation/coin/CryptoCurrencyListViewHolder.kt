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
import com.yigitozgumus.home_screen.databinding.LayoutCryptoCurrencyListItemBinding
import com.yigitozgumus.home_screen.databinding.LayoutHomeScreenErrorBinding
import com.yigitozgumus.home_screen.domain.mapper.CurrencyDetailScreenMapper
import com.yigitozgumus.home_screen.domain.navigation.CoinInteractionOwner

sealed class CryptoCurrencyListViewHolder(view: View) : RecyclerView.ViewHolder(view)

class CryptoCurrencyListContentViewHolder(
    parent: ViewGroup,
    private val binding: LayoutCryptoCurrencyListItemBinding = LayoutCryptoCurrencyListItemBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false
    )
) : CryptoCurrencyListViewHolder(binding.root) {

    fun bind(model: CryptoCurrencyListContentUiModel, coinInteractionOwner: CoinInteractionOwner) {
        binding.coinName.text = model.name
        binding.coinImage.load(model.imageUrl)
        binding.currentPriceAmount.text = "${model.currentPrice} ${model.currentCurrency.uppercase()}"
        itemView.setOnClickListener {
            coinInteractionOwner.goToDetailScreen(CurrencyDetailScreenMapper().mapToDetailUiModel(model))
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

    fun bind(model: CryptoCurrencyListErrorUiModel) {
        binding.errorTitle.text = SpannableStringBuilder()
            .color(
                ContextCompat.getColor(
                    parent.context,
                    com.yigitozgumus.ui.R.color.black
                )
            ) { append(model.currencyName) }
            .append(" ")
            .append(parent.context.getString(model.errorMessage))

    }

}
