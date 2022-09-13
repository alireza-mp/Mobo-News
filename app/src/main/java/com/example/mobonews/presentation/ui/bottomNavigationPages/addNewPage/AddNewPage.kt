package com.example.mobonews.presentation.ui.bottomNavigationPages.addNewPage

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun AddNewPage(
    navHostController: NavHostController,
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center,){
        Text(text = "add new page")
    }
}