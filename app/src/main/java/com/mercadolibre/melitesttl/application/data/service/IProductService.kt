package com.mercadolibre.melitesttl.application.data.service

import com.mercadolibre.test.data.model.ResultList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IProductService {

    @GET("search")
    suspend fun getProducts(@Query("q") text: String): Response<ResultList>

}