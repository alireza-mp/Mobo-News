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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.mobonews.R
import com.example.mobonews.domain.model.FavoriteNews

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FavoriteNewsItem(
    modifier: Modifier = Modifier,
    model: FavoriteNews,
    onClick: (Int) -> Unit,
) {
    Card(
        backgroundColor = MaterialTheme.colors.surface,
        modifier = modifier.fillMaxWidth().height(145.dp)
            .padding(start = 1.dp, end = 1.dp, bottom = 16.dp),
        shape = MaterialTheme.shapes.large,
        onClick = { onClick(model.id) },
    ) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier.size(135.dp)
                    .padding(horizontal = 8.dp, vertical = 8.dp),
            ) {
                AsyncImage(
                    modifier = Modifier.fillMaxSize()
                        .clip(MaterialTheme.shapes.large),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(model.imageUrl)
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
                Chips(
                    modifier = Modifier.align(Alignment.TopStart)
                        .padding(top = 8.dp, start = 8.dp),
                    title = model.category
                )
            }
            Spacer(modifier = Modifier.padding(end = 8.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = model.title,
                    color = MaterialTheme.colors.primaryVariant,
                    style = MaterialTheme.typography.h2,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )

                Spacer(modifier = Modifier.padding(top = 8.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = model.description,
                    color = MaterialTheme.colors.secondary,
                    style = MaterialTheme.typography.h5,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
                Spacer(modifier = Modifier.padding(top = 8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    AsyncImage(
                        modifier = Modifier.size(24.dp)
                            .clip(MaterialTheme.shapes.medium),
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(model.publisherImageUrl)
                            .crossfade(true)
                            .build(),
                        contentDescription = null,
                    )
                    Spacer(modifier = Modifier.padding(end = 8.dp))
                    Text(
                        text = model.publisher,
                        color = MaterialTheme.colors.primaryVariant,
                        style = MaterialTheme.typography.h5,
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    CustomIconButton(
                        id = R.drawable.ic_menu,
                        onClick = {},
                    )
                }
            }
            Spacer(modifier = Modifier.padding(end = 16.dp))
        }
    }
}