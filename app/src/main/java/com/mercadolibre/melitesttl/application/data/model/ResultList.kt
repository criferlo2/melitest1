package com.mercadolibre.test.data.model

import com.google.gson.annotations.SerializedName

data class ResultList(
    @SerializedName("query") val query: String,
    @SerializedName("results") val results: List<Results>,
)