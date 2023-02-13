package com.mercadolibre.melitesttl.application.ui.components.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mercadolibre.melitesttl.application.ui.components.SearchBar
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