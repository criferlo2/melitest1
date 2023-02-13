package com.mercadolibre.melitesttl.application.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun ProductDetail(
    productTitle: String?,
    productPrice: String?,
    productThumbnail: String?,
    productAvailable: String?,
    productSeller: String?
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        val urlThumbnail = "http://http2.mlstatic.com/$productThumbnail"
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(urlThumbnail)
                .crossfade(true)
                .build(),
            //placeholder = painterResource(id = drawable),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(128.dp)
        )
    }
}