/*
 * Created by yigitozgumus on 4/2/22, 1:30 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 4/2/22, 1:30 PM
 */

package com.yigitozgumus.home_screen.presentation.coin

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class CryptoCurrencyListAdapter :
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
        return CryptoCurrencyListViewHolder(parent)
    }

    override fun onBindViewHolder(holder: CryptoCurrencyListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
