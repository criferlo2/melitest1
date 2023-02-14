package com.mercadolibre.melitesttl

import com.mercadolibre.melitesttl.application.data.repository.ProductRepository
import com.mercadolibre.melitesttl.application.data.repository.response.ResponseObject
import com.mercadolibre.melitesttl.application.data.service.IProductService
import com.mercadolibre.test.data.model.ResultList
import com.mercadolibre.test.data.model.Results
import kotlinx.coroutines.test.runTest
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody.Part.Companion.create
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import retrofit2.Response

class RepositoryUnitTest {

    private val resultList = ResultList(
        "query", listOf(
            Results(
                id = "1",
                title = "title",
                condition = "condition",
                thumbnail_id = "thumb",
                catalog_product_id = "catalog",
                listing_type_id = "listing",
                permalink = "permalink",
                buying_mode = "buying",
                site_id = "site",
                category_id = "category",
                domain_id = "domain",
                variation_id = "variation",
                thumbnail = "thumb",
                currency_id = "currency",
                order_backend = 1,
                price = 0.toDouble(),
                original_price = "0",
                sale_price = "123",
                sold_quantity = 123,
                available_quantity = 11,
                official_store_id = "1",
                use_thumbnail_id = true,
                accepts_mercadopago = true,
                tags = listOf("tags"),
                variation_filters = listOf("filters"),
                stop_time = "10",
                winner_item_id = "111",
                discounts = "333",
                promotions = listOf("prom"),
                inventory_id = "111"
            )
        )
    )

    @Test
    fun should_get_products_from_service_success() = runTest {
        //given
        val mockService = Mockito.mock(IProductService::class.java)
        val response = Response.success(resultList)
        val repository = ProductRepository(mockService)

        //when
        Mockito.`when`(mockService.getProducts("iphone")).thenReturn(response)

        val result:ResponseObject<Any> = repository.getProducts("iphone")

        //then
        Mockito.verify(mockService).getProducts("iphone")
        assertEquals("title", ((result as ResponseObject.Success).data as ResultList).results[0].title)
    }

    @Test
    fun should_get_products_from_service_error() = runTest {
        //given
        val mockService = Mockito.mock(IProductService::class.java)

        val response = Response.error<ResultList>(
            400,
            "{\"error\":[\"message error\"]}"
                .toResponseBody("application/json".toMediaTypeOrNull())
        )

        val repository = ProductRepository(mockService)

        //when
        Mockito.`when`(mockService.getProducts("iphone")).thenReturn(response)

        val result:ResponseObject<Any> = repository.getProducts("iphone")

        //then
        Mockito.verify(mockService).getProducts("iphone")
        assertEquals(400, (result as ResponseObject.Error).code)
    }
}