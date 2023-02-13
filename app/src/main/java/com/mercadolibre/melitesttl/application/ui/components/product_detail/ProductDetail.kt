package com.mercadolibre.melitesttl.application.ui.components.product_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mercadolibre.melitesttl.R
import com.mercadolibre.melitesttl.ui.theme.md_theme_light_primaryContainer
import com.mercadolibre.melitesttl.ui.theme.md_theme_light_secondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetail(
    productTitle: String?,
    productPrice: String?,
    productThumbnail: String?,
    productAvailable: String?,
    productSeller: String?
) {
    Scaffold(
        topBar = {
            BarDetail()
        },
        content = { paddingValues ->
            ContentDetail(
                modifier = Modifier.padding(paddingValues),
                productTitle,
                productPrice,
                productThumbnail,
                productAvailable,
                productSeller
            )
        }
    )
}

@Composable
fun BarDetail() {
    Row(
        modifier = Modifier
            .background(color = md_theme_light_primaryContainer)
            .fillMaxWidth()
            .height(60.dp)
            .padding(horizontal = 0.dp, vertical = 0.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Text(
            "Enviar a Cristhian Lombana Manzana F Casa 3 #SN..",
            modifier = Modifier.padding(start = 5.dp, top = 5.dp),
        )
    }
}

@Composable
fun ButtonBuyProduct() {
    Button(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 5.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor =  md_theme_light_secondary
        ),
        shape = RoundedCornerShape(10),

    ) {
        Text("Comprar ahora", style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun ContentDetail(
    modifier: Modifier,
    productTitle: String?,
    productPrice: String?,
    productThumbnail: String?,
    productAvailable: String?,
    productSeller: String?
) {
    val urlThumbnail = "http://http2.mlstatic.com/$productThumbnail"
    val padding = 16.dp
    Column(modifier = modifier) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(Modifier.size(padding))
            Text(
                modifier = Modifier.padding(start = 5.dp, top = 5.dp),
                text = productTitle ?: "title",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Left
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.size(padding))
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(urlThumbnail)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(200.dp)
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Spacer(Modifier.size(padding))
            Text(
                modifier = Modifier.padding(start = 5.dp, top = 5.dp),
                text = "$ $productPrice",
                style = MaterialTheme.typography.labelLarge,
                textAlign = TextAlign.Left
            )
            Spacer(Modifier.size(padding))
            Text(
                modifier = Modifier.padding(start = 5.dp, top = 5.dp),
                text = "Disponibles $productAvailable",
                style = MaterialTheme.typography.titleSmall,
                textAlign = TextAlign.Left
            )
            Spacer(Modifier.size(padding))
            Text(
                modifier = Modifier.padding(start = 5.dp, top = 5.dp),
                text = "Vendido por $productSeller",
                style = MaterialTheme.typography.titleSmall,
                textAlign = TextAlign.Left
            )
        }
        Spacer(Modifier.size(padding))
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            ButtonBuyProduct()
        }
    }
}