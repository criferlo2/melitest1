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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mercadolibre.melitesttl.application.ui.components.Product
import com.mercadolibre.melitesttl.application.ui.components.SearchBar
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
            MeliTestTLTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Body()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Body() {
    MeliTestTLTheme {
        Scaffold(
            topBar = {
                SearchBar()
            },
            content = { paddingValues -> Content(modifier = Modifier.padding(paddingValues)) }
        )
    }
}

@Composable
fun Content(modifier: Modifier) {

    val configuration = LocalConfiguration.current
    val widthCard = (configuration.screenWidthDp.dp / 2)
    val productsEmpty = arrayListOf<ResultList>()
    var viewModel: ProductViewModel = viewModel()
    val products = viewModel.productsLiveData.observeAsState()

    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Adaptive(minSize = widthCard)
    ) {
        items(products.value ?: productsEmpty) { prod ->
            Product(prod as Results, R.drawable.ic_launcher_background)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Body()
}