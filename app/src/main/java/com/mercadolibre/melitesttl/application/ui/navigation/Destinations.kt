package com.mercadolibre.melitesttl.application.ui.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

interface DestinationsMeli {
    val route: String
}

object MainDestination : DestinationsMeli {
    override val route = "main"
}

object ProductDetailDestination : DestinationsMeli {
    override val route = "product_detail"
    const val product_title = "product_title"
    const val product_price = "product_price"
    const val product_thumbnail = "product_thumbnail"
    const val product_available = "product_available"
    const val product_seller = "product_available"
    val arguments = listOf(
        navArgument(product_title) { type = NavType.StringType },
        navArgument(product_price) { type = NavType.StringType },
        navArgument(product_thumbnail) { type = NavType.StringType },
        navArgument(product_available) { type = NavType.StringType },
        navArgument(product_seller) { type = NavType.StringType },
        )
    val routeWithArgs = "$route/{$product_title}/{$product_price}/{$product_thumbnail}/{$product_available}/{$product_seller}"
}