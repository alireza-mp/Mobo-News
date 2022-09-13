package com.example.mobonews.presentation.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ehsanmsz.mszprogressindicator.progressindicator.BallPulseProgressIndicator

@Composable
fun BallProgress(modifier: Modifier) {

    BallPulseProgressIndicator(
        modifier = modifier,
        color = MaterialTheme.colors.primary,
        ballCount = 4,
        spacing = 6.dp
    )

}