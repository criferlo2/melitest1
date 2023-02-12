package com.mercadolibre.melitesttl

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mercadolibre.melitesttl.application.ui.viewmodel.ProductViewModel
import com.mercadolibre.melitesttl.ui.theme.MeliTestTLTheme
import com.mercadolibre.melitesttl.ui.theme.md_theme_light_primaryContainer
import com.mercadolibre.test.data.model.ResultList
import com.mercadolibre.test.data.model.Results
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeliTestTLTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Body()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Body() {

    MeliTestTLTheme {
        Scaffold(
            topBar = {
                SearchBar()
            },
            content = { paddingValues -> ContentMeli(modifier = Modifier.padding(paddingValues)) }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarMeli() {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Outlined.AccountBox, contentDescription = null)
            }
        },
        title = { Text(text = "MELI") },
        actions = {}
    )
}

@Composable
fun ContentMeli2(modifier: Modifier) {

    Column(modifier = modifier) {


        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("http://http2.mlstatic.com/D_791924-MLA53428740417_012023-O.jpg")
                .crossfade(true)
                .size(coil.size.Size.ORIGINAL)
                .build(),
            placeholder = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
        )
    }

}

@Composable
fun ContentMeli(modifier: Modifier) {

    val configuration = LocalConfiguration.current
    val widthCard = (configuration.screenWidthDp.dp / 2)


    val productsEmpty = arrayListOf<ResultList>()


    var viewModel: ProductViewModel = viewModel()

    val products = viewModel.productsLiveData.observeAsState()

    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Adaptive(minSize = widthCard)
    ) {
        items(products.value ?: productsEmpty) { prod ->
            Product(prod as Results)
        }
    }
}

@Composable
fun SearchBar() {
    Row(
        modifier = Modifier
            .background(color = md_theme_light_primaryContainer)
            .fillMaxWidth()
            .height(60.dp)
            .padding(horizontal = 0.dp, vertical = 0.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = CenterVertically

    ) {
        SearchField()
    }
}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalUnitApi::class)
@Composable
fun SearchField() {

    var text by remember { mutableStateOf(TextFieldValue()) }
    var viewModel: ProductViewModel = viewModel()

    TextField(
        value = text,
        onValueChange = {
            text = it
            viewModel.getProducts(text.text)
        },
        shape = RoundedCornerShape(50),
        placeholder = {

            Text(
                text = "Buscar en Meli",
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .absoluteOffset(y = (-1).dp)
            )
        },
        modifier = Modifier
            .height(46.dp)
            .fillMaxWidth()
            .padding(start = 40.dp, end = 40.dp),
        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = null,
                Modifier
                    .height(15.dp)
                    .width(15.dp)
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            textColor = Color.Gray,
            disabledTextColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Product(prod: Results) {
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
                placeholder = painterResource(id = R.drawable.ic_launcher_background),
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

@Composable
fun ImageResourceDemo() {
    val image: Painter = painterResource(id = R.drawable.ic_launcher_background)
    Image(painter = image, contentDescription = "")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Body()
}