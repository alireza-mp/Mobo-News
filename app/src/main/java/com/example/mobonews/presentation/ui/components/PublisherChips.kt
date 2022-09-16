package com.example.mobonews.presentation.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.mobonews.presentation.theme.White
import com.example.mobonews.presentation.theme.publisherChips

@Composable
fun PublisherChips(
    modifier: Modifier = Modifier,
    title: String,
    imageUrl: String,
) {

    Card(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.primary,
        shape = MaterialTheme.shapes.medium,
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AsyncImage(
                modifier = Modifier.size(24.dp)
                    .clip(MaterialTheme.shapes.medium),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.padding(end = 8.dp))
            Text(
                text = title,
                color = MaterialTheme.colors.White,
                style = MaterialTheme.typography.publisherChips,
            )
        }
    }

}


