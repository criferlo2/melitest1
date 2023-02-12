package com.mercadolibre.test.data.repository

import com.mercadolibre.melitesttl.application.data.repository.response.ResponseObject

interface IProductRepository {
    fun getSomethingOfRepository(): String
    suspend fun getProducts(text: String): ResponseObject<Any>
}