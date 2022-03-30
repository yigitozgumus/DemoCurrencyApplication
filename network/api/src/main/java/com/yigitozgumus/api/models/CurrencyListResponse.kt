package com.yigitozgumus.api.models

import com.google.gson.annotations.SerializedName

data class CurrencyListResponse(
    @SerializedName("data") var data: ArrayList<Currency> = arrayListOf()
)
