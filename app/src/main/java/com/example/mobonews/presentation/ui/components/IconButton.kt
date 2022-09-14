package com.example.mobonews.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.IconButton
import androidx.compose.material.LocalMinimumTouchTargetEnforcement
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CustomIconButton(modifier: Modifier = Modifier, id: Int, onClick: () -> Unit) {
    CompositionLocalProvider(LocalMinimumTouchTargetEnforcement provides false) {
        IconButton(
            modifier = modifier,
            onClick = onClick,
            content = {
                Image(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id),
                    contentDescription = null,
                )
            }
        )
    }
}