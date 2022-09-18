package com.example.mobonews.presentation.ui.bottomNavigationPages.discoverPage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mobonews.domain.model.HotNews
import com.example.mobonews.presentation.theme.White
import com.example.mobonews.presentation.ui.components.*
import com.example.mobonews.util.Categories

@Composable
fun DiscoverPage(
    navHostController: NavHostController,
) {
    Content(navHostController)
}

@Composable
private fun Content(navHostController: NavHostController) {
    val selectedCategory = remember { mutableStateOf(Categories.All) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize()
                .background(color = MaterialTheme.colors.background)
                .verticalScroll(rememberScrollState()),
        ) {

            Spacer(modifier = Modifier.padding(top = 16.dp))
            CustomImagePager(
                padding = PaddingValues(horizontal = 16.dp),
                imagesUrl = listOf(
                    "https://digimoplus.ir/mobonews/banner_1.jpg",
                    "https://digimoplus.ir/mobonews/banner_2.jpg",
                    "https://digimoplus.ir/mobonews/banner_1.jpg",
                    "https://digimoplus.ir/mobonews/banner_2.jpg",
                    "https://digimoplus.ir/mobonews/banner_1.jpg",
                    "https://digimoplus.ir/mobonews/banner_2.jpg",
                )
            )

            Spacer(modifier = Modifier.padding(top = 16.dp))
            LazyRow(modifier = Modifier.fillMaxWidth().padding(start = 16.dp)) {
                itemsIndexed(
                    items = Categories.getCategoriesAsList(),
                    key = { index, item -> item },
                ) { index, item ->
                    Chips(
                        modifier = Modifier.padding(end = 12.dp),
                        title = item.title,
                        enabled = selectedCategory.value.title == item.title,
                        onClick = {
                            selectedCategory.value = item
                        }
                    )
                }
            }

            // publishers list title
            Spacer(modifier = Modifier.padding(top = 8.dp))
            ListTitle(
                padding = PaddingValues(horizontal = 16.dp),
                title = "خبرگزاری ها",
                onClick = {},
            )
            Spacer(modifier = Modifier.padding(top = 8.dp))


            // publishers list
            LazyRow(modifier = Modifier.fillMaxWidth().padding(start = 16.dp)) {
                items(count = 10) {
                    PublisherItem(
                        modifier = Modifier.padding(end = 16.dp)
                    ) {

                    }
                }
            }


            // secretary's proposal list title
            Spacer(modifier = Modifier.padding(top = 8.dp))
            ListTitle(
                padding = PaddingValues(horizontal = 16.dp),
                title = "پیشنهاد سردبیر",
                onClick = {},
            )
            Spacer(modifier = Modifier.padding(top = 8.dp))


            LazyRow(modifier = Modifier.fillMaxWidth().padding(start = 16.dp)) {
                items(
                    count = 6,
                ) { index ->
                    HotNewsItem(
                        HotNews(
                            "علمی پزشکی",
                            id = 2,
                            newsId = 2,
                            imageUrl = "",
                            publisher = "خبر گذاری اخرین خبر",
                            publisherImageUrl = "",
                            recommended = "پیشنهاد موبو نیوز",
                            title = "پــاسـخ منـفـی پــورتـــو بـه چلـسـی بـرای جذب  طارمی با طعم تهدید!",
                            time = "5 دقیقه پیش",
                        ),
                        onClick = {}
                    )
                }
            }
            Spacer(modifier = Modifier.padding(bottom = 62.dp))
        }
        AutoSubtitel(
            modifier = Modifier.align(Alignment.BottomCenter),
            navController = navHostController,
            text = "بی نظمی شدید در مراسم رونمایی از کاپ جام جهانی و قهر نماینده فیفا  # برانکو تکذیب کرد: نه با عمان فسخ کردم، نه با ایران مذاکره داشتم",
            color = MaterialTheme.colors.White,
            style = MaterialTheme.typography.h2,
        )
    }
}