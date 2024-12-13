package com.project.mindmap.ui.pages.onboarding.carousal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable

class OnboardingCarousalActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OnboardingCarousalScreen()
        }
    }
}

@Composable
fun OnboardingCarousalScreen(){
    CarousalScreen()
}