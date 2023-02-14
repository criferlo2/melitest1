package com.mercadolibre.melitesttl.application.ui.components.home

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mercadolibre.melitesttl.application.ui.components.Product
import com.mercadolibre.melitesttl.application.ui.viewmodel.ProductViewModel
import com.mercadolibre.melitesttl.application.data.model.ResultList
import com.mercadolibre.test.data.model.Results


@Composable
fun Content(
    modifier: Modifier,
    onClickDetail: (title: String, price: String, thumbnail: String, available: String, seller: String) -> Unit,
    drawable: Int
) {

    val configuration = LocalConfiguration.current
    val widthCard = (configuration.screenWidthDp.dp / 2)
    val productsEmpty = arrayListOf<ResultList>()
    var viewModel: ProductViewModel = hiltViewModel()
    val products = viewModel.productsLiveData.observeAsState()

    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Adaptive(minSize = widthCard),

        ) {
        items(products.value ?: productsEmpty) { prod ->
            Product(prod as Results, drawable, onClickDetail)
        }
    }
}