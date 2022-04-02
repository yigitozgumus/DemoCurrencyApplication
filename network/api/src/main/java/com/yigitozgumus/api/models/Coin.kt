/*
 * Created by yigitozgumus on 4/2/22, 11:44 AM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 4/2/22, 11:44 AM
 */

package com.yigitozgumus.api.models

import com.google.gson.annotations.SerializedName


data class Coin(

    @SerializedName("id") var id: String? = null,
    @SerializedName("symbol") var symbol: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("current_price") var currentPrice: Double? = null,
    @SerializedName("market_cap") var marketCap: Long? = null,
    @SerializedName("market_cap_rank") var marketCapRank: Long? = null,
    @SerializedName("fully_diluted_valuation") var fullyDilutedValuation: Long? = null,
    @SerializedName("total_volume") var totalVolume: Long? = null,
    @SerializedName("high_24h") var high24h: Double? = null,
    @SerializedName("low_24h") var low24h: Double? = null,
    @SerializedName("price_change_24h") var priceChange24h: Double? = null,
    @SerializedName("price_change_percentage_24h") var priceChangePercentage24h: Double? = null,
    @SerializedName("market_cap_change_24h") var marketCapChange24h: Double? = null,
    @SerializedName("market_cap_change_percentage_24h") var marketCapChangePercentage24h: Double? = null,
    @SerializedName("circulating_supply") var circulatingSupply: Double? = null,
    @SerializedName("total_supply") var totalSupply: Double? = null,
    @SerializedName("max_supply") var maxSupply: Double? = null,
    @SerializedName("ath") var ath: Double? = null,
    @SerializedName("ath_change_percentage") var athChangePercentage: Double? = null,
    @SerializedName("ath_date") var athDate: String? = null,
    @SerializedName("atl") var atl: Double? = null,
    @SerializedName("atl_change_percentage") var atlChangePercentage: Double? = null,
    @SerializedName("atl_date") var atlDate: String? = null,
    @SerializedName("last_updated") var lastUpdated: String? = null

)
