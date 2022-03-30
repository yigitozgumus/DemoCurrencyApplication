package com.yigitozgumus.api.models

import com.google.gson.annotations.SerializedName

data class Currency(
    @SerializedName("id") var id: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("min_size") var minSize: String? = null
)
