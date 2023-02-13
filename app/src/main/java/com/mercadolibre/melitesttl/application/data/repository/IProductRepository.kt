package com.mercadolibre.melitesttl.application.data.repository

import com.mercadolibre.melitesttl.application.data.repository.response.ResponseObject

interface IProductRepository {
    suspend fun getProducts(text: String): ResponseObject<Any>
}