package com.project.mindmap.ui.pages.login

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.project.mindmap.ui.pages.splash.SplashDesign
import com.project.mindmap.ui.theme.BoldH3White
import com.project.mindmap.ui.theme.NonBoldH2
import com.project.mindmap.ui.theme.NonBoldH3
import com.project.mindmap.ui.theme.outfitFontFamily

@Composable
fun LoginScreenComposable(navController: NavController){
    Box(modifier = Modifier
        .fillMaxHeight()
        .background(color = Color(0XFFf8f8f8)),
        contentAlignment = Alignment.BottomCenter) {
        Column(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(color = Color(0XFFf8f8f8))
            .padding(16.dp),
            verticalArrangement = Arrangement.Center) {
            Box (modifier = Modifier
            ){
                Text(text = "Login",
                    style = TextStyle(
                        fontSize = 40.sp,
                        fontFamily = outfitFontFamily,
                        color = Color(0XFF3b88e3),
                        fontWeight = FontWeight.Bold
                    ))
            }
            Text(text = "Welcome Back!",
                style = NonBoldH2)
            Spacer(modifier = Modifier.height(24.dp))
            LoginCredentialsComposable(navController)
        }
        Box (modifier = Modifier
            .offset(x = (0).dp, y = 140.dp)
            .fillMaxWidth()
            .scale(0.5f),
            contentAlignment = Alignment.BottomCenter
        ){
            SplashDesign()
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginCredentialsComposable(navController: NavController){
    Column {
        Text(text = "Enter your Email Id")
        LoginCredentialsField("Your E-mail")
        Text(text = "Enter your Password")
        LoginCredentialsField("Password")
        SignInOptions(navController)
        ContinueButton(navController)
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginCredentialsField(hint:String){
    Box (
        modifier= Modifier.
        padding(vertical = 16.dp)
    ){
        OutlinedTextField(
            value = "",
            onValueChange = {},
            textStyle = NonBoldH3,
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Color.White,
                    shape = RoundedCornerShape(16.dp)
                )
                .border(
                    width = 2.dp,
                    color = Color(0XFFe4e4e4),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(horizontal = 8.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color(0XFF3b88e3),
            ),
            placeholder = {
                Text(text = hint,
                    style = NonBoldH3)
            },
        )
    }
}


@Composable
fun SignInOptions(navController: NavController){
    val mContext = LocalContext.current
    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween){
        Text(text = "Forget Password?", style = NonBoldH3)
        Text(text = "New User?",
            style = TextStyle(
                fontFamily = outfitFontFamily,
                color = Color(0XFF3b88e3),
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp

            ),
            modifier = Modifier
                .pointerInput(Unit) {
                    detectTapGestures(
                        onTap = {
                            navController.navigate("signup")
                        })
                }
        )
    }
}

@Composable
fun ContinueButton(navController: NavController){
    val mContext = LocalContext.current
    Button(
        colors = ButtonDefaults.buttonColors(
            Color(0XFF3b88e3)),
        modifier = Modifier
            .fillMaxWidth()
            ,
        onClick = {
            navController.navigate("onboardingForm")
        }) {
        Text(text = "Continue", style = BoldH3White)

    }
}