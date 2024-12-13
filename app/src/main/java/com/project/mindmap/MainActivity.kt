package com.project.mindmap
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.project.mindmap.ui.pages.splash.SplashActivity
import com.project.mindmap.ui.pages.splash.SplashScreen
import com.project.mindmap.ui.theme.MindmapTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            window.statusBarColor = getColor(R.color.white)
            MindmapTheme {
                // Launch SplashActivity
                startActivity(Intent(this, SplashActivity::class.java))

                // Finish MainActivity to prevent the user from navigating back to it
                finish()
            }
        }
    }

}
