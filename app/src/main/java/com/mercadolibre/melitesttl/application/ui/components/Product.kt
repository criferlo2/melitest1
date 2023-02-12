package com.mercadolibre.melitesttl.application.ui.components

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
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
fun Product(prod: Results, drawable: Int) {
    val configuration = LocalConfiguration.current
    val widthCard = (configuration.screenWidthDp.dp / 2)

    ElevatedCard(
        onClick = {},
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

            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(prod.thumbnail)
                    .crossfade(true)
                    //.size(coil.size.Size.ORIGINAL)
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
            style = MaterialTheme.typography.titleSmall,
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