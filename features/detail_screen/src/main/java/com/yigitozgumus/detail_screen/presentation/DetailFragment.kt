/*
 * Created by yigitozgumus on 4/4/22, 10:17 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 4/4/22, 10:17 PM
 */

package com.yigitozgumus.detail_screen.presentation

import android.text.SpannableStringBuilder
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.color
import androidx.fragment.app.viewModels
import coil.load
import com.yigitozgumus.base_feature.base.BaseFragment
import com.yigitozgumus.base_feature.content.BindingInflater
import com.yigitozgumus.detail_screen.databinding.FragmentDetailBinding
import com.yigitozgumus.domain.navigation.DetailNavigationInfoUiModel
import com.yigitozgumus.ui.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment() {

    private val uiModel: DetailNavigationInfoUiModel? by lazy { arguments?.getParcelable(argumentKey) }

    override val viewModel: DetailViewModel by viewModels()

    override val bindingInflater = BindingInflater(FragmentDetailBinding::inflate) {
        setupToolbar()
        detailScreenCoinImage.load(uiModel?.coinImage)
        detailScreenCoinName.text = "${uiModel?.coinName} (${uiModel?.symbol})"
        detailScreenLowestPriceLabel.text = getLowestPriceLabelText()
        detailScreenHighestPriceLabel.text = getHighestPriceLabelText()
        detailScreenLastUpdatedTime.text = "Last updated time: ${uiModel?.lastUpdatedTime}"
    }

    private fun FragmentDetailBinding.setupToolbar() {
        toolbar.run {
            setBackgroundColor(resources.getColor(R.color.black))
            title = "${uiModel?.coinName} Detail Screen"
            setNavigationIcon(androidx.appcompat.R.drawable.abc_ic_ab_back_material)
            setNavigationIconTint(resources.getColor(R.color.white))
            setNavigationOnClickListener { (activity as AppCompatActivity).onSupportNavigateUp() }
        }
    }

    private fun getHighestPriceLabelText() = SpannableStringBuilder()
        .append("Highest price in 24 hours: ")
        .color(resources.getColor(R.color.black)) { append(" ${uiModel?.highestPrice}") }
        .append(" ${uiModel?.currentCurrency}")

    private fun getLowestPriceLabelText() = SpannableStringBuilder()
        .append("Lowest price in 24 hours: ")
        .color(resources.getColor(R.color.black)) { append(" ${uiModel?.lowestPrice}") }
        .append(" ${uiModel?.currentCurrency}")


    companion object {
        val argumentKey: String = DetailFragment::class.java.name
    }

}
