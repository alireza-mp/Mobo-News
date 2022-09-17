package com.example.mobonews.presentation.ui.bottomNavigationPages.discoverPage

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mobonews.presentation.ui.components.Chips
import com.example.mobonews.presentation.ui.components.CustomImagePager
import com.example.mobonews.util.Categories

@Composable
fun DiscoverPage(
    navHostController: NavHostController,
) {
    Content()
}

@Composable
private fun Content() {
    val selectedCategory = remember { mutableStateOf(Categories.All) }

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
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
        }
        item {
            Spacer(modifier = Modifier.padding(top = 8.dp))
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
        }
        // publishers list title
        item {
            Spacer(modifier = Modifier.padding(top = 8.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    "خبرگزاری ها",
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.primaryVariant,
                )
                Spacer(modifier = Modifier.weight(1f))
                TextButton(onClick = {

                }) {
                    Text(
                        text = "مشاهده بیشتر",
                        style = MaterialTheme.typography.h4,
                        color = MaterialTheme.colors.primary,
                    )
                }
            }
            Spacer(modifier = Modifier.padding(top = 8.dp))
        }

        item {
            Spacer(modifier = Modifier.padding(top = 8.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    "پیشنهاد سردبیر",
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.primaryVariant,
                )
                Spacer(modifier = Modifier.weight(1f))
                TextButton(onClick = {

                }) {
                    Text(
                        text = "مشاهده بیشتر",
                        style = MaterialTheme.typography.h4,
                        color = MaterialTheme.colors.primary,
                    )
                }
            }
            Spacer(modifier = Modifier.padding(top = 8.dp))
        }

    }
}