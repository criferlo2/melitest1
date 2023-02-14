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
import com.mercadolibre.melitesttl.application.ui.components.home.ErrorScreen
import com.mercadolibre.melitesttl.application.ui.components.product_detail.ProductDetail
import com.mercadolibre.melitesttl.application.ui.navigation.NavHostMeli
import com.mercadolibre.melitesttl.application.ui.viewmodel.ErrorUI
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
   ErrorScreen(modifier = Modifier.fillMaxWidth().fillMaxHeight()
       , error = ErrorUI(500, "Ocurre un error")
   )
}