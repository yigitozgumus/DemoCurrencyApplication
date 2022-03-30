package com.yigitozgumus.api.models

import com.google.gson.annotations.SerializedName


data class Coin(

    @SerializedName("id") var id: String? = null,
    @SerializedName("symbol") var symbol: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("current_price") var currentPrice: Int? = null,
    @SerializedName("market_cap") var marketCap: Int? = null,
    @SerializedName("market_cap_rank") var marketCapRank: Int? = null,
    @SerializedName("fully_diluted_valuation") var fullyDilutedValuation: Int? = null,
    @SerializedName("total_volume") var totalVolume: Int? = null,
    @SerializedName("high_24h") var high24h: Int? = null,
    @SerializedName("low_24h") var low24h: Int? = null,
    @SerializedName("price_change_24h") var priceChange24h: Double? = null,
    @SerializedName("price_change_percentage_24h") var priceChangePercentage24h: Double? = null,
    @SerializedName("market_cap_change_24h") var marketCapChange24h: Double? = null,
    @SerializedName("market_cap_change_percentage_24h") var marketCapChangePercentage24h: Double? = null,
    @SerializedName("circulating_supply") var circulatingSupply: Int? = null,
    @SerializedName("total_supply") var totalSupply: Int? = null,
    @SerializedName("max_supply") var maxSupply: Int? = null,
    @SerializedName("ath") var ath: Int? = null,
    @SerializedName("ath_change_percentage") var athChangePercentage: Double? = null,
    @SerializedName("ath_date") var athDate: String? = null,
    @SerializedName("atl") var atl: Double? = null,
    @SerializedName("atl_change_percentage") var atlChangePercentage: Double? = null,
    @SerializedName("atl_date") var atlDate: String? = null,
    @SerializedName("roi") var roi: String? = null,
    @SerializedName("last_updated") var lastUpdated: String? = null

)
