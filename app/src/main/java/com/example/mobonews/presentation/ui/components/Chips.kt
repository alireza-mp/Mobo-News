package com.example.mobonews.presentation.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mobonews.presentation.theme.White

@Composable
fun Chips(
    modifier: Modifier = Modifier,
    title: String,
) {
    Card(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.primary.copy(0.5f),
        shape = MaterialTheme.shapes.medium,
    ) {
        Text(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp),
            text = title,
            color = MaterialTheme.colors.White,
            style = MaterialTheme.typography.h4,
        )
    }
}