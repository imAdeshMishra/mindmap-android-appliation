package com.project.mindmap.ui.pages.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.project.mindmap.R
import com.project.mindmap.ui.theme.BoldH1Black
import com.project.mindmap.ui.theme.NonBoldH2
import com.project.mindmap.ui.theme.NonBoldH3

@Composable
fun HomeScreen(navController: NavController){
    Column (
        modifier = Modifier
            .fillMaxHeight()
            .background(color = Color.White)
    ){
        HomeScreenTopBar()
        FeelingComposable()
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenTopBar() {
    Box(
        modifier = Modifier
            .background(
                Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFFFFFFF),
                        Color(0xFFFFD7E0)
                    ),
                    start = Offset(0f, 0f),
                    end = Offset(0f, Float.POSITIVE_INFINITY)
                )
            ),
    ) {
        Image(
            painter = painterResource(id = R.drawable.home_sticker1),
            contentDescription = "",
            modifier = Modifier
                .size(200.dp)
                .offset(x = (200).dp, y = 48.dp)

        )
        // Main content
        Column(
            modifier = Modifier
                .padding(vertical = 16.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .height(80.dp),
            ) {
                Column {
                    Box(
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "Good Morning Hiral",
                            style = BoldH1Black
                        )
                    }
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                    ) {
                        Text(
                            text = "Get started with your healing journey",
                            style = NonBoldH2
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.End
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.account_holder_avatar),
                        contentDescription = "",
                        modifier = Modifier.size(80.dp)
                    )
                }
            }
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            ) {
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
                            width = 1.dp,
                            color = Color.White,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .padding(horizontal = 8.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                    ),
                    prefix = {
                        Icon(
                            Icons.Rounded.Search,
                            contentDescription = "",
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    placeholder = {
                        Text(text = "Search for Programs")
                    },
                    suffix = {
                        Icon(
                            painter = painterResource(id = R.drawable.microphone_icon),
                            contentDescription = "",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun FeelingComposable(){
    Column(modifier = Modifier
        .padding(16.dp)) {
        Text(text = "How are you feeling today?")

        Box(modifier = Modifier
            .padding(vertical = 16.dp)

            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color(0XFFe4e4e4),
                shape = RoundedCornerShape(16.dp)
            ),
            contentAlignment = Alignment.Center
        ){
            Row (modifier = Modifier
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
                ){
                for (i in emojis){
                    Box (Modifier.padding(horizontal = 12.dp, vertical = 16.dp)){
                        Image(painter = painterResource(id = i),
                            contentDescription ="" ,
                            Modifier.size(32.dp))
                    }

                }
            }
        }
    }
}

var emojis = listOf<Int>(
    R.drawable.feeling_icon1,
    R.drawable.feeling_icon2,
    R.drawable.feeling_icon3,
    R.drawable.feeling_icon4,
    R.drawable.feeling_icon5,
    R.drawable.feeling_icon6,
)
