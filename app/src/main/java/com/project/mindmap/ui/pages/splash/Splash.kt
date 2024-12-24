package com.project.mindmap.ui.pages.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.project.mindmap.ui.theme.outfitFontFamily


@Composable
fun SplashScreen(navController: NavController){
    LaunchedEffect(Unit) {
        kotlinx.coroutines.delay(2000) // 2 seconds delay
        navController.navigate("onboardingForm") {
            // Optional: clear the back stack to avoid returning to the splash screen
            popUpTo("splash") { inclusive = true }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White), // Set background to white
        contentAlignment = Alignment.Center // Center the splash design
    ) {
            Box(
                modifier = Modifier
                    .scale(2.0f) // Increase the scale to zoom in
            ) {
                SplashDesign()
            }
            Text(
                text = "Mind-Map.",
                style = TextStyle(
                    color = Color.White, // White text color
                    fontSize = 40.sp, // Font size
                    fontWeight = FontWeight.Bold, // Bold text
                    fontFamily = outfitFontFamily,
                    textAlign = TextAlign.Center // Align text center
                )
            )


        Text(
            text = "Your One Stop Mental Health Destination",
            modifier = Modifier
                .align(Alignment.BottomCenter) // Align text at the bottom center
                .padding(16.dp), // Add padding at the bottom
            style = TextStyle(
                color = Color.Gray, // Set text color
                fontSize = 12.sp, // Set font size
                textAlign = TextAlign.Center, // Center align text
                fontFamily = outfitFontFamily,
            )
        )
    }
}

@Composable
fun SplashDesign(){
    Box (modifier= Modifier
        .size(280.dp)
        .clip(CircleShape)
        .background(color = Color(0XFF096dc8))
        .padding(24.dp),contentAlignment = Alignment.Center

    ){
        Box (modifier= Modifier
            .clip(CircleShape)
            .background(color = Color(0XFF62b4ff))
            .padding(24.dp),contentAlignment = Alignment.Center
        ){
            Box (modifier= Modifier
                .clip(CircleShape)
                .background(color = Color(0XFF59a5ff))
                .padding(24.dp),contentAlignment = Alignment.Center
            ){

                Box (modifier= Modifier
                    .clip(CircleShape)
                    .background(color = Color(0XFF3b88e3))
                    .padding(24.dp) ,contentAlignment = Alignment.Center
                ){
                    Box (modifier= Modifier
                        .size(200.dp)
                        .clip(CircleShape)
                        .background(color = Color(0XFF62b4ff))
                        ,
                        contentAlignment = Alignment.Center
                    ){

                    }

                }

            }
        }
    }
}



