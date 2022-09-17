package com.example.mobonews.presentation.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PublisherItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Card(
        modifier = modifier,
        onClick = onClick,
        shape = MaterialTheme.shapes.medium,
        backgroundColor = MaterialTheme.colors.surface,
    ) {
        Column(
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AsyncImage(
                modifier = Modifier.size(66.dp)
                    .clip(MaterialTheme.shapes.medium),
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://digimoplus.ir/mobonews/publisher_favorite_news_1.png")
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.padding(top = 8.dp))
            Text(
                text = "زومیت",
                color = MaterialTheme.colors.primaryVariant,
                style = MaterialTheme.typography.h3,
            )
            Spacer(modifier = Modifier.padding(top = 8.dp))
            Chips(
                title = "دنبال کردن",
                textColor = MaterialTheme.colors.primary,
                backgroundColor = MaterialTheme.colors.onPrimary,
                textStyle = MaterialTheme.typography.h2,
                innerPadding = PaddingValues(vertical = 4.dp, horizontal = 12.dp),
                onClick = {

                }
            )
        }

    }

}