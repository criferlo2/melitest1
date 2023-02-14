package com.mercadolibre.melitesttl

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mercadolibre.melitesttl.application.data.repository.IProductRepository
import com.mercadolibre.melitesttl.application.data.repository.response.ResponseObject
import com.mercadolibre.melitesttl.application.ui.viewmodel.ProductViewModel
import com.mercadolibre.melitesttl.application.data.model.ResultList
import com.mercadolibre.test.data.model.Results
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import org.mockito.Mockito

@OptIn(ExperimentalCoroutinesApi::class)
class ViewModelTest{

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: ProductViewModel
    private lateinit var mockRepository: IProductRepository

    @Before
    fun setUp() {
        mockRepository = Mockito.mock(IProductRepository::class.java)
        viewModel = ProductViewModel(mockRepository)
    }

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
    fun should_get_products_from_repository() = runTest {
        //given
        val response = ResponseObject.Success<Any>(resultList)

        //when
        Mockito.`when`(mockRepository.getProducts("iphone")).thenReturn(response)

        viewModel.getProducts("iphone")

        //then
        launch {
            Mockito.verify(mockRepository).getProducts("iphone")
        }
    }
}

@ExperimentalCoroutinesApi
class MainCoroutineRule(private val dispatcher: TestDispatcher = StandardTestDispatcher()) :
    TestWatcher() {

    override fun starting(description: Description?) {
        super.starting(description)
        Dispatchers.setMain(dispatcher)
    }

    override fun finished(description: Description?) {
        super.finished(description)
        Dispatchers.resetMain()
    }
}