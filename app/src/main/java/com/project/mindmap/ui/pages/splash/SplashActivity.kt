package com.project.mindmap.ui.pages.splash
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.project.mindmap.ui.pages.onboarding.carousal.OnboardingCarousalActivity

import com.project.mindmap.ui.pages.onboarding.form.OnboardingFormActivity
import com.project.mindmap.ui.pages.server.ServerConnectionActivity

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Start a coroutine to delay and navigate
        CoroutineScope(Dispatchers.Main).launch {
            delay(2000) // 2-second delay
            navigateToUserCategoryActivity()
        }

        setContent {
            SplashScreenComposable()
        }
    }

    private fun navigateToUserCategoryActivity() {

//        startActivity(Intent(this, ServerConnectionActivity::class.java))
        startActivity(Intent(this, OnboardingFormActivity::class.java))

        finish() // Close SplashActivity so it doesn't stay in the back stack
    }
}

@Preview
@Composable
fun SplashScreenComposable(){
    SplashScreen()
}