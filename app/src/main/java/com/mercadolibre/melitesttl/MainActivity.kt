package com.mercadolibre.melitesttl

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.mercadolibre.melitesttl.application.ui.components.product_detail.ProductDetail
import com.mercadolibre.melitesttl.application.ui.navigation.NavHostMeli
import com.mercadolibre.melitesttl.ui.theme.MeliTestTLTheme
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    /*ProductDetail(
        productTitle = "Audifonos",
        productPrice = "1000",
        productThumbnail = "D_791924-MLA53428740417_012023-O.jpg",
        productAvailable = "10",
        productSeller = "SELLER109",
        painterResource(id = R.drawable.ic_launcher_background)
    )*/
}