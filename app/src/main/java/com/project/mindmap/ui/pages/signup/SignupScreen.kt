package com.project.mindmap.ui.pages.signup


import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.background
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.project.mindmap.models.LoginCredentials
import com.project.mindmap.ui.pages.splash.SplashDesign
import com.project.mindmap.ui.theme.BoldH3White
import com.project.mindmap.ui.theme.NonBoldH2
import com.project.mindmap.ui.theme.NonBoldH3
import com.project.mindmap.ui.theme.outfitFontFamily
import com.project.mindmap.viewmodel.UserViewModel


@Composable
fun SignupScreenComposable(navController: NavController){
    val userViewModel: UserViewModel = hiltViewModel()
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
                Text(text = "SignUp",
                    style = TextStyle(
                        fontSize = 40.sp,
                        fontFamily = outfitFontFamily,
                        color = Color(0XFF3b88e3),
                        fontWeight = FontWeight.Bold
                    ))
            }
            Text(text = "Welcome!",
                style = NonBoldH2)
            Spacer(modifier = Modifier.height(24.dp))
            SignupCredentialsComposable(navController,userViewModel)
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
fun SignupCredentialsComposable(navController: NavController,viewModel: UserViewModel){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column {
        Text(text = "Enter your Email Id")
        SignupCredentialsField("Your E-mail", email) { email = it }
        Text(text = "Enter your Password")
        SignupCredentialsField("Create Password", password) { password = it }
        SignupOptions(navController)
        ContinueButton(navController,email,password,viewModel)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupCredentialsField(hint: String, value: String, onValueChange: (String) -> Unit) {
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
fun SignupOptions(navController: NavController){
    val mContext = LocalContext.current
    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 8.dp),
        horizontalArrangement = Arrangement.End){
//        Text(text = "Forget Password?", style = NonBoldH3)
        Text(text = "Already a user?",
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
                            navController.navigate("login")
                        })
                }
        )
    }
}


@Composable
fun ContinueButton(navController: NavController,email: String, password: String, viewModel: UserViewModel) {
    val mContext = LocalContext.current

    Button(
        colors = ButtonDefaults.buttonColors(Color(0XFF3b88e3)),
        modifier = Modifier.fillMaxWidth(),
        onClick = {
            if (email.isNotBlank() && password.isNotBlank()) {
                // Create user credentials
                val userCredentials = LoginCredentials(email, password)

                // Call the ViewModel to hit the API
                viewModel.createUser(userCredentials) { responseBody, error ->
                    if (responseBody != null) {
                        Toast.makeText(mContext, "User Created: ${responseBody["status"]}", Toast.LENGTH_SHORT).show()
                        navController.navigate("userCategory")
                    } else {
                        Toast.makeText(mContext, error ?: "Unknown Error", Toast.LENGTH_SHORT).show()
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
