package com.mercadolibre.melitesttl.application.ui.components.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.mercadolibre.melitesttl.application.ui.components.SearchBar
import com.mercadolibre.melitesttl.application.ui.viewmodel.ErrorUI
import com.mercadolibre.melitesttl.application.ui.viewmodel.ProductViewModel
import com.mercadolibre.melitesttl.ui.theme.MeliTestTLTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Main(
    onClickDetail: (
        title: String,
        price: String,
        thumbnail: String,
        available: String,
        seller: String
    ) -> Unit,
    drawable: Int
) {
    MeliTestTLTheme {
        Scaffold(
            topBar = {
                SearchBar()
            },
            content = { paddingValues ->

                var viewModel: ProductViewModel = hiltViewModel()
                val error = viewModel.errorLiveData.observeAsState()
                if(error.value?.message?.isNotEmpty() == true){
                    ErrorScreen(
                        modifier = Modifier.padding(paddingValues),
                        error = ErrorUI(error.value?.code ?: 500, error.value?.message ?: "Error")
                    )
                }else{
                    Content(
                        modifier = Modifier.padding(paddingValues),
                        onClickDetail,
                        drawable
                    )
                }
            }
        )
    }
}