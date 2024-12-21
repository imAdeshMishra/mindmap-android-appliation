package com.project.mindmap.ui.pages.server

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.project.mindmap.backend.network.RetrofitInstance
import com.project.mindmap.ui.pages.splash.SplashDesign
import com.project.mindmap.ui.theme.BoldH3White
import com.project.mindmap.ui.theme.NonBoldH2
import com.project.mindmap.ui.theme.NonBoldH3
import com.project.mindmap.ui.theme.outfitFontFamily
import kotlinx.coroutines.launch

@Composable
fun ServerConnectionScreenComposable(navController: NavController){

    LaunchedEffect(Unit) {
        kotlinx.coroutines.delay(2000) // 2 seconds delay
        navController.navigate("serverConnection") {
            // Optional: clear the back stack to avoid returning to the splash screen
            popUpTo("splash") { inclusive = true }
        }
    }

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
                Text(text = "Server Setup",
                    style = TextStyle(
                        fontSize = 40.sp,
                        fontFamily = outfitFontFamily,
                        color = Color(0XFF3b88e3),
                        fontWeight = FontWeight.Bold
                    )
                )
            }
            Text(text = "Welcome!",
                style = NonBoldH2
            )
            Spacer(modifier = Modifier.height(24.dp))
            ServerCredentialsComposable(navController)
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

@Composable
fun ServerCredentialsComposable(navController: NavController){
    var ipAddress by remember { mutableStateOf("192.168.1.1") }
    Column {
        Text(text = "Enter your Server IP Address")
        ServerCredentialsField("198.168.1.1", ipAddress) { ipAddress = it }
        ContinueButton(navController,ipAddress)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServerCredentialsField(hint: String, value: String, onValueChange: (String) -> Unit) {
    val focusRequester = remember { FocusRequester() }
    var isFocused by remember { mutableStateOf(false) }

    Box(modifier = Modifier.padding(vertical = 16.dp)) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = NonBoldH3,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(16.dp))
                .focusRequester(focusRequester)
                .onFocusChanged { focusState -> isFocused = focusState.isFocused }
                .drawBehind {
                    val borderWidth = 2.dp.toPx()
                    val borderColor = if (isFocused) Color(0XFF3b88e3) else Color(0XFFe4e4e4)
                    val radius = 16.dp.toPx()
                    drawRoundRect(
                        color = borderColor,
                        size = size,
                        cornerRadius = CornerRadius(radius, radius),
                        style = Stroke(width = borderWidth)
                    )
                },
            placeholder = { Text(text = hint, style = NonBoldH3) },
        )
    }
}


@Composable
fun ContinueButton(navController: NavController,ipAddress: String) {
    val mContext = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    Button(
        colors = ButtonDefaults.buttonColors(Color(0XFF3b88e3)),
        modifier = Modifier.fillMaxWidth(),
        onClick = {
            if (ipAddress.isNotBlank()) {
                val baseUrl = "http://$ipAddress:8080/"
                RetrofitInstance.setBaseUrl(baseUrl) // Set the base URL once

                coroutineScope.launch {
                    try {
                        val response = RetrofitInstance.getAPI().establishConnection()
                        if (response.isSuccessful) {
                            val responseBody = response.body() // Retrieve the response body
                            if (responseBody != null && responseBody["status"] == "success") {
                                // Success case: Connection established
                                Toast.makeText(
                                    mContext,
                                    "Connection Successful! ${responseBody["message"]}",
                                    Toast.LENGTH_SHORT
                                ).show()

                                navController.navigate("carousal")
                            } else {
                                // Backend returned failure status
                                Toast.makeText(
                                    mContext,
                                    "Failed: ${responseBody?.get("message") ?: "Unknown Error"}",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        } else {
                            // Non-successful HTTP response
                            Toast.makeText(
                                mContext,
                                "Failed to connect: ${response.code()}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } catch (e: Exception) {
                        Toast.makeText(
                            mContext,
                            "Error: ${e.localizedMessage}",
                            Toast.LENGTH_SHORT
                        ).show()

                        Log.d("Server Connection","Error: ${e.localizedMessage}")

                    }
                }

            } else {
                Toast.makeText(mContext, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
    ) {
        Text(text = "Continue", style = BoldH3White)
    }
}

