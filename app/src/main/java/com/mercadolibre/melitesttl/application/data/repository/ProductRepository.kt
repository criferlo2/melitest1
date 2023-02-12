package com.mercadolibre.melitesttl.application.data.repository

import com.mercadolibre.test.data.model.ResultList
import com.mercadolibre.melitesttl.application.data.repository.response.ResponseObject
import com.mercadolibre.melitesttl.application.data.service.IProductService
import com.mercadolibre.test.data.repository.IProductRepository
import retrofit2.Response
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val productService: IProductService
) : IProductRepository {
    override fun getSomethingOfRepository() = "something from Repository"
    override suspend fun getProducts(text: String): ResponseObject<Any> {
        val listProducts: Response<ResultList> = productService.getProducts(text)
        return if (listProducts.isSuccessful) {
            listProducts.body()?.let { list ->
                ResponseObject.Success(data = list)
            } ?: ResponseObject.Error(code = listProducts.code(), "Body empty")
        } else {
            ResponseObject.Error(code = listProducts.code(), listProducts.message())
        }
    }
}