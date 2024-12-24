package com.project.mindmap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.project.mindmap.ui.pages.community.CommunitiesScreen
import com.project.mindmap.ui.pages.dailywellness.DailyWellnessScreen
import com.project.mindmap.ui.pages.elite.EliteScreen
import com.project.mindmap.ui.pages.home.HomeScreen
import com.project.mindmap.ui.pages.login.LoginScreenComposable
import com.project.mindmap.ui.pages.navbar.BottomNavBarComposable
import com.project.mindmap.ui.pages.onboarding.carousal.CarousalScreen
import com.project.mindmap.ui.pages.onboarding.category.CategoryScreenComposable
import com.project.mindmap.ui.pages.onboarding.form.FormScreen
import com.project.mindmap.ui.pages.onboarding.form.OnboardingScreenComposable
import com.project.mindmap.ui.pages.programs.ProgramLibraryScreen
import com.project.mindmap.ui.pages.server.ServerConnectionScreenComposable
import com.project.mindmap.ui.pages.signup.SignupScreenComposable
import com.project.mindmap.ui.pages.splash.SplashScreen
import com.project.mindmap.ui.pages.therapistis.TherapistsScreen
import com.project.mindmap.ui.theme.MindmapTheme
import com.project.mindmap.ui.theme.Pink40
import com.project.mindmap.ui.theme.Pink80
import com.project.mindmap.ui.theme.PurpleGrey40
import com.project.mindmap.ui.theme.PurpleGrey80


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            window.statusBarColor = getColor(R.color.white)
            MindmapTheme {
                val isDarkTheme = isSystemInDarkTheme()
                val statusBarColor = if (isDarkTheme) DarkColorScheme.primary else LightColorScheme.primary

                // Update the status bar color and icons
                SideEffect {
                    window.statusBarColor = statusBarColor.toArgb()
                    WindowCompat.getInsetsController(window, window.decorView).isAppearanceLightStatusBars = true
                }
                MindmapApp()
            }
        }
    }
}

@Composable
fun MindmapApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "navbar") {
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
        composable("dailyWellness") {
            DailyWellnessScreen(navController)
        }
        composable("navbar") {
            BottomNavBarComposable(navController)
        }
    }
}


private val DarkColorScheme = darkColorScheme(
    primary = Color.White,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Color.White,
    secondary = PurpleGrey40,
    tertiary = Pink40

)