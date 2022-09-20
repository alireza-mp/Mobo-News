package com.example.mobonews.presentation.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ListTitle(
    modifier: Modifier = Modifier,
    padding: PaddingValues = PaddingValues(),
    title: String,
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier.fillMaxWidth()
            .padding(padding),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            title,
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.primaryVariant,
        )
        Spacer(modifier = Modifier.weight(1f))
        TextButton(onClick = onClick) {
            Text(
                text = "مشاهده بیشتر",
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.primary,
            )
        }
    }
}