package com.project.mindmap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.project.mindmap.ui.pages.home.HomeScreen
import com.project.mindmap.ui.pages.login.LoginScreenComposable
import com.project.mindmap.ui.pages.onboarding.carousal.CarousalScreen
import com.project.mindmap.ui.pages.onboarding.category.CategoryScreenComposable
import com.project.mindmap.ui.pages.onboarding.form.FormScreen
import com.project.mindmap.ui.pages.onboarding.form.OnboardingScreenComposable
import com.project.mindmap.ui.pages.server.ServerConnectionScreenComposable
import com.project.mindmap.ui.pages.signup.SignupScreenComposable
import com.project.mindmap.ui.pages.splash.SplashScreen
import com.project.mindmap.ui.theme.MindmapTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.statusBarColor = getColor(R.color.white)
            MindmapTheme {
                MindmapApp()
            }
        }
    }
}

@Composable
fun MindmapApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SplashScreen(navController)
        }
        composable("serverConnection") {
            ServerConnectionScreenComposable(navController)
        }
        composable("login") {
            LoginScreenComposable(navController)
        }
        composable("signup") {
            SignupScreenComposable(navController)
        }
        composable("carousal") {
            CarousalScreen(navController)
        }
        composable("onboardingForm") {
            OnboardingScreenComposable(navController)
        }
        composable("userCategory") {
            CategoryScreenComposable(navController)
        }
        composable("userRequirement") {
            FormScreen(navController)
        }
        composable("home") {
            HomeScreen(navController)
        }
    }
}