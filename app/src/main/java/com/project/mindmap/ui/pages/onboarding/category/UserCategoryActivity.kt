package com.project.mindmap.ui.pages.onboarding.category

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

class UserCategoryActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CategoryScreenComposable(applicationContext)
        }
    }
}

@Composable
fun CategoryScreenComposable(context: Context) {
    val selectedCategory = remember{ mutableIntStateOf(1) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White), // Background for the whole screen
        verticalArrangement = Arrangement.SpaceBetween // Space between components
    ) {
        // Top Content
        Box(modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center) {
            CategoryScreen(selectedCategory = selectedCategory, context = context)
        }


        // Bottom Button
        ContinueButton(selectedCategory = selectedCategory)
    }
}