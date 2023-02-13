package com.mercadolibre.melitesttl

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mercadolibre.melitesttl.application.ui.components.Product
import com.mercadolibre.melitesttl.application.ui.components.ProductDetail
import com.mercadolibre.melitesttl.application.ui.components.SearchBar
import com.mercadolibre.melitesttl.application.ui.navigation.NavHostMeli
import com.mercadolibre.melitesttl.application.ui.viewmodel.ProductViewModel
import com.mercadolibre.melitesttl.ui.theme.MeliTestTLTheme
import com.mercadolibre.test.data.model.ResultList
import com.mercadolibre.test.data.model.Results
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            MeliTestTLTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHostMeli(navController = navController)
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Main(
    onClickDetail: (
        title: String,
        price: String,
        thumbnail: String,
        available: String,
        seller: String
    ) -> Unit
) {
    MeliTestTLTheme {
        Scaffold(
            topBar = {
                SearchBar()
            },
            content = { paddingValues ->
                Content(
                    modifier = Modifier.padding(paddingValues),
                    onClickDetail
                )
            }
        )
    }
}

@Composable
fun Content(
    modifier: Modifier,
    onClickDetail: (title: String, price: String, thumbnail: String, available: String, seller: String) -> Unit
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
            Product(prod as Results, R.drawable.ic_launcher_background, onClickDetail)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProductDetail(
        productTitle = "Audifonos",
        productPrice = "1000",
        productThumbnail = "D_791924-MLA53428740417_012023-O.jpg",
        productAvailable = "10",
        productSeller = "SELLER109"
    )
}