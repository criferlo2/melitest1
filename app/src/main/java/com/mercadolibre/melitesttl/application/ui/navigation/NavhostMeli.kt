package com.mercadolibre.melitesttl.application.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mercadolibre.melitesttl.R
import com.mercadolibre.melitesttl.application.ui.components.home.Main
import com.mercadolibre.melitesttl.application.ui.components.product_detail.ProductDetail

@Composable
fun NavHostMeli(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = MainDestination.route,
        modifier = modifier
    ) {
        composable(route = MainDestination.route) {
            Main(
                onClickDetail = { title,
                                  price,
                                  thumbnail,
                                  available,
                                  seller ->
                    navController.navigate("${ProductDetailDestination.route}/$title/$price/$thumbnail/$available/$seller")

                },
                drawable = R.drawable.ic_launcher_background
            )
        }

        composable(
            route = ProductDetailDestination.routeWithArgs,
            arguments = ProductDetailDestination.arguments
        ) { navBackStackEntry ->
            val productTitle =
                navBackStackEntry.arguments?.getString(ProductDetailDestination.product_title)
            val productPrice =
                navBackStackEntry.arguments?.getString(ProductDetailDestination.product_price)
            val productThumbnail =
                navBackStackEntry.arguments?.getString(ProductDetailDestination.product_thumbnail)
            val productAvailable =
                navBackStackEntry.arguments?.getString(ProductDetailDestination.product_available)
            val productSeller =
                navBackStackEntry.arguments?.getString(ProductDetailDestination.product_seller)

            ProductDetail(
                productTitle,
                productPrice,
                productThumbnail,
                productAvailable,
                productSeller,
                drawable = painterResource(id = R.drawable.ic_launcher_background)
            )
        }
    }
}