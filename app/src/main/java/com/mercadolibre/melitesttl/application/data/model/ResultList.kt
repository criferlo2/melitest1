package com.mercadolibre.melitesttl.application.data.model

import com.google.gson.annotations.SerializedName
import com.mercadolibre.test.data.model.Results

data class ResultList(
    @SerializedName("query") val query: String,
    @SerializedName("results") val results: List<Results>,
)