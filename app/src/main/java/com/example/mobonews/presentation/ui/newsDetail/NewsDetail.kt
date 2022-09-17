package com.example.mobonews.presentation.ui.newsDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.mobonews.R
import com.example.mobonews.presentation.ui.components.*
import com.example.mobonews.util.UiState


@Composable
fun NewsDetailPage(
    newsId: String,
) {
    val viewModel: NewsDetailViewModel = hiltViewModel()

    when (viewModel.uiState.value) {
        UiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize()
                    .background(color = MaterialTheme.colors.background),
                contentAlignment = Alignment.Center,
            ) {
                BallProgress()
            }
        }
        UiState.Success -> {
            Content(viewModel)
        }
        UiState.Error -> {
            ErrorView {
                viewModel.initialData(newsId = newsId.toInt())
            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.initialData(newsId = newsId.toInt())
    }

}


@Composable
private fun Content(viewModel: NewsDetailViewModel) {

    val model = remember { viewModel.newsDetail.value }

    Box(modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colors.background)) {

        Image(
            modifier = Modifier.fillMaxWidth().height(300.dp)
                .alphaAnimation(delay = 500, 800),
            painter = rememberAsyncImagePainter(model = model?.imageUrl ?: ""),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier.fillMaxSize()
                .verticalScroll(rememberScrollState()),
        ) {
            Spacer(modifier = Modifier.padding(top = 270.dp))
            Card(
                modifier = Modifier.fillMaxWidth()
                    .offsetXAnimation(
                        delay = 0,
                        duration = 500,
                        startOffset = 400.dp,
                        endOffset = 0.dp,
                    ),
                shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
                backgroundColor = MaterialTheme.colors.surface,
            ) {
                Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                    Spacer(modifier = Modifier.padding(top = 12.dp))
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Row(
                            modifier = Modifier.align(Alignment.CenterStart),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Image(
                                modifier = Modifier.size(18.dp),
                                painter = painterResource(R.drawable.ic_flash),
                                contentDescription = null,
                            )
                            Spacer(modifier = Modifier.padding(end = 8.dp))
                            Text(
                                text = model?.recommended ?: "",
                                color = MaterialTheme.colors.secondary,
                                style = MaterialTheme.typography.h5,
                            )
                        }
                        PublisherChips(
                            modifier = Modifier.align(Alignment.Center),
                            title = model?.publisher ?: "",
                            imageUrl = "https://digimoplus.ir/mobonews/publisher_hot_news_1.png",
                        )
                        Text(
                            modifier = Modifier.align(Alignment.CenterEnd),
                            text = model?.time ?: "",
                            color = MaterialTheme.colors.secondary,
                            style = MaterialTheme.typography.h5,
                        )
                    }
                    Spacer(modifier = Modifier.padding(top = 16.dp))
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = model?.title ?: "",
                        color = MaterialTheme.colors.primaryVariant,
                        style = MaterialTheme.typography.h1,
                    )
                    Spacer(modifier = Modifier.padding(top = 12.dp))
                    LazyRow(modifier = Modifier.fillMaxWidth()) {
                        itemsIndexed(items = model?.categoryList ?: listOf()) { _, item ->
                            Chips(
                                modifier = Modifier.padding(end = 12.dp),
                                title = item.title,
                                textColor = MaterialTheme.colors.primary,
                                backgroundColor = MaterialTheme.colors.onPrimary,
                            )
                        }
                    }
                    Spacer(modifier = Modifier.padding(top = 12.dp))
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = model?.description ?: "",
                        color = MaterialTheme.colors.primaryVariant,
                        style = MaterialTheme.typography.h3,
                        lineHeight = 23.sp,
                    )
                    Spacer(modifier = Modifier.padding(top = 12.dp))
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = model?.body ?: "",
                        color = MaterialTheme.colors.primaryVariant,
                        style = MaterialTheme.typography.body2,
                        lineHeight = 23.sp,
                    )
                    Spacer(modifier = Modifier.padding(top = 16.dp))
                }
            }

        }

    }
}