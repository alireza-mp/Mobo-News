package com.example.mobonews.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ehsanmsz.mszprogressindicator.progressindicator.BallPulseProgressIndicator

@Composable
fun BallProgressView() {

    Box(
        modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colors.background),
        contentAlignment = Alignment.Center,
    ) {
        BallPulseProgressIndicator(
            color = MaterialTheme.colors.primary,
            ballCount = 4,
            spacing = 6.dp
        )
    }

}