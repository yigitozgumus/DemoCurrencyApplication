/*
 * Created by yigitozgumus on 4/2/22, 1:30 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 4/2/22, 1:30 PM
 */

package com.yigitozgumus.home_screen.presentation.coin

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.yigitozgumus.home_screen.domain.navigation.CoinInteractionOwner

class CryptoCurrencyListAdapter(
    private val coinInteractionOwner: CoinInteractionOwner
) :
    ListAdapter<CryptoCurrencyListUiModel, CryptoCurrencyListViewHolder>(CryptoCurrencyItemCallback()) {

    class CryptoCurrencyItemCallback : DiffUtil.ItemCallback<CryptoCurrencyListUiModel>() {
        override fun areItemsTheSame(oldItem: CryptoCurrencyListUiModel, newItem: CryptoCurrencyListUiModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: CryptoCurrencyListUiModel,
            newItem: CryptoCurrencyListUiModel
        ): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoCurrencyListViewHolder {
        return when (ViewHolderType.values()[viewType]) {
            ViewHolderType.CONTENT -> CryptoCurrencyListContentViewHolder(parent)
            ViewHolderType.ERROR -> CryptoCurrencyListErrorViewHolder(parent)
        }
    }

    override fun onBindViewHolder(holder: CryptoCurrencyListViewHolder, position: Int) {
        when (holder) {
            is CryptoCurrencyListContentViewHolder -> holder.bind(
                getItem(position) as
                        CryptoCurrencyListContentUiModel, coinInteractionOwner
            )
            is CryptoCurrencyListErrorViewHolder -> holder.bind(getItem(position) as CryptoCurrencyListErrorUiModel)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is CryptoCurrencyListContentUiModel -> ViewHolderType.CONTENT.ordinal
            is CryptoCurrencyListErrorUiModel -> ViewHolderType.ERROR.ordinal
        }
    }

    enum class ViewHolderType {
        CONTENT,
        ERROR
    }
}
