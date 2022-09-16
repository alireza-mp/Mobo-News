package com.example.mobonews.presentation.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ErrorView(
    padding: PaddingValues = PaddingValues(),
    onRetry: () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize().padding(padding),
        contentAlignment = Alignment.Center,
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "خطا در برقراری ارتباط",
                style = MaterialTheme.typography.h2,
                color = MaterialTheme.colors.primaryVariant,
            )
            Spacer(modifier = Modifier.padding(top = 16.dp))
            TextButton(onClick = onRetry) {
                Text(
                    text = "تلاش مجدد",
                    style = MaterialTheme.typography.h4,
                    color = MaterialTheme.colors.primary,
                )
            }
        }
    }
}