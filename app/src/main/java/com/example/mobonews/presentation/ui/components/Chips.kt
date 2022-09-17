package com.example.mobonews.presentation.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.mobonews.presentation.theme.White

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Chips(
    modifier: Modifier = Modifier,
    title: String,
    textColor: Color = MaterialTheme.colors.White,
    textStyle: TextStyle = MaterialTheme.typography.h4,
    backgroundColor: Color = MaterialTheme.colors.primary.copy(0.5f),
    innerPadding: PaddingValues = PaddingValues(vertical = 8.dp, horizontal = 12.dp),
    onClick: (() -> Unit)? = null,
) {
    Card(
        modifier = modifier,
        backgroundColor = backgroundColor,
        shape = MaterialTheme.shapes.medium,
        enabled = onClick != null,
        onClick = { onClick?.invoke() },
    ) {
        Text(
            modifier = Modifier.padding(innerPadding),
            text = title,
            color = textColor,
            style = textStyle,
        )
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Chips(
    modifier: Modifier = Modifier,
    title: String,
    enabled: Boolean,
    onClick: () -> Unit,
) {
    Card(
        modifier = modifier,
        backgroundColor = if (enabled)
            MaterialTheme.colors.onPrimary else MaterialTheme.colors.White,
        shape = MaterialTheme.shapes.medium,
        enabled = !enabled, // disable enabled item onClick
        onClick = onClick,
    ) {
        Text(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp),
            text = title,
            color = if (enabled) MaterialTheme.colors.primary else MaterialTheme.colors.secondary,
            style = MaterialTheme.typography.h4,
        )
    }
}