package com.example.mobonews.presentation.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun CustomImagePager(
    padding: PaddingValues = PaddingValues(),
    imagesUrl: List<String>,
) {
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
    Box(modifier = Modifier.fillMaxSize()) {

        HorizontalPager(
            count = imagesUrl.size,
            modifier = Modifier.fillMaxWidth()
                .height(200.dp),
            state = pagerState,
        ) { page ->
            AsyncImage(
                modifier = Modifier.fillMaxSize()
                    .padding(padding)
                    .clip(MaterialTheme.shapes.medium),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imagesUrl[page])
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
            )
        }

        PagerIndicator(
            modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 16.dp),
            activeColor = MaterialTheme.colors.primary,
            inActiveColor = MaterialTheme.colors.secondary,
            pagerState = pagerState,
            onClick = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(it)
                }
            }
        )

    }

    LaunchedEffect(Unit) {
        var page: Int
        while (true) {
            delay(3000)
            page = if (pagerState.currentPage == imagesUrl.size - 1)
                0 else pagerState.currentPage + 1
            pagerState.animateScrollToPage(page)
        }
    }

}

