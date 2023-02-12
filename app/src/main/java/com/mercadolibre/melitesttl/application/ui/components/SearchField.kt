package com.mercadolibre.melitesttl.application.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mercadolibre.melitesttl.application.ui.viewmodel.ProductViewModel


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