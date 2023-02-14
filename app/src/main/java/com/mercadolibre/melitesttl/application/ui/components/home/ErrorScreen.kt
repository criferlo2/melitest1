package com.mercadolibre.melitesttl.application.ui.components.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.mercadolibre.melitesttl.application.ui.viewmodel.ErrorUI
import com.mercadolibre.melitesttl.ui.theme.md_theme_dark_error
import com.mercadolibre.melitesttl.ui.theme.md_theme_dark_errorContainer

@Composable
fun ErrorScreen(
    modifier: Modifier,
    error: ErrorUI
) {
    Column(
        modifier = modifier
            .background(md_theme_dark_errorContainer)
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Text(
            text = "Oh! disculpa! No pudimos obtener los datos.",
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center
        )
        Text(
            text = error.message,
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )

    }
}