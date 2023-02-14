package com.mercadolibre.melitesttl.application.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mercadolibre.melitesttl.application.ui.components.home.SearchField
import com.mercadolibre.melitesttl.ui.theme.md_theme_light_primaryContainer

@Composable
fun SearchBar() {
    Row(
        modifier = Modifier
            .background(color = md_theme_light_primaryContainer)
            .fillMaxWidth()
            .height(60.dp)
            .padding(horizontal = 0.dp, vertical = 0.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically

    ) {
        SearchField()
    }
}