package com.example.mobonews.presentation.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.alphaAnimation(enabled: Boolean = true, delay: Int, duration: Int) = composed {
    if (enabled) {
        val anim = remember { Animatable(initialValue = 0f) }

        LaunchedEffect(anim) {
            anim.animateTo(
                targetValue = 1f,
                animationSpec = tween(
                    durationMillis = duration,
                    delayMillis = delay,
                )
            )
        }

        this.alpha(anim.value)
    } else this
}

fun Modifier.offsetXAnimation(delay: Int, duration: Int, startOffset: Dp, endOffset: Dp) =
    composed {
        val animState = remember { mutableStateOf(startOffset) }
        val offsetX by animateDpAsState(
            targetValue = animState.value,
            animationSpec = tween(
                durationMillis = duration,
                delayMillis = delay,
            )
        )
        LaunchedEffect(Unit) {
            animState.value = endOffset
        }
        this.offset(x = 0.dp, y = offsetX)
    }