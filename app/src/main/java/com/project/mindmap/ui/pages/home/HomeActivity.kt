    package com.project.mindmap.ui.pages.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

    class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}