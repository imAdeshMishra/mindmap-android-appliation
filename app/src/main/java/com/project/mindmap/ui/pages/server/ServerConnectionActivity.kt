package com.project.mindmap.ui.pages.server

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class ServerConnectionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ServerConnectionScreenComposable()
        }
    }
}