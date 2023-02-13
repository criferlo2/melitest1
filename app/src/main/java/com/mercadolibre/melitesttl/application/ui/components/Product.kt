package com.mercadolibre.melitesttl.application.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mercadolibre.test.data.model.Results


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Product(
    prod: Results,
    drawable: Int,
    onClickDetail: (title: String, price: String, thumbnail: String, available: String, seller: String) -> Unit
) {
    val configuration = LocalConfiguration.current
    val widthCard = (configuration.screenWidthDp.dp / 2)

    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        onClick = {
            onClickDetail.invoke(
                prod.title,
                prod.price.toString(),
                normalizeUrl(prod.thumbnail),
                prod.available_quantity.toString(),
                prod.domain_id
            )
        },
        modifier = Modifier
            .width(width = widthCard - 10.dp)
            .wrapContentHeight()
            .padding(all = 10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(all = 5.dp),

            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(prod.thumbnail)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(id = drawable),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(128.dp)
            )

        }
        Text(
            modifier = Modifier.padding(start = 5.dp, top = 5.dp),
            text = prod.title,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Left
        )
        Text(
            modifier = Modifier.padding(start = 5.dp, top = 5.dp),
            text = "$ ${prod.price}",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Left
        )

    }
}

fun normalizeUrl(thumbnail: String): String = thumbnail.substring(26, thumbnail.length)
