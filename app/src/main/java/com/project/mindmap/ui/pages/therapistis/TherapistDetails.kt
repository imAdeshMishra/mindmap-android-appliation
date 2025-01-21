package com.project.mindmap.ui.pages.therapistis

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.mindmap.R
import com.project.mindmap.ui.theme.BoldH1Black
import com.project.mindmap.ui.theme.BoldLargeBlack
import com.project.mindmap.ui.theme.NonBoldH2
import com.project.mindmap.ui.theme.NonBoldH3
import com.project.mindmap.ui.theme.NonBoldH4

@Preview
@Composable
fun TherapistDetailsScreen() {

    Scaffold(
        Modifier.background(color = Color(0XFFf8f8f8)),
        topBar = {
            TherapistDetailsAppBar()
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .background(color = Color.White)
                .padding(paddingValues)
        ) {
            TherapistInformationComposable()

        }
    }
}

@Composable
fun TherapistInformationComposable(){
    Box (modifier = Modifier
        .fillMaxWidth()
//        .height(360.dp)
//        .background(color = Color.Cyan)
    ){
        Box (modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .background(color = Color(0XFFffd7e0))
        )
        Box(
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp) // Position the text within the image
                .background(
                    color = Color.White.copy(alpha = 0.8f), // Semi-transparent white background
                    shape = RoundedCornerShape(4.dp)
                )
                .padding(4.dp) // Inner padding for the text box
        ) {
            Row (modifier = Modifier.padding(horizontal = 4.dp),
                verticalAlignment = Alignment.CenterVertically){
                Icon(Icons.Default.PlayArrow,
                    contentDescription = "",
                    tint = Color(0XFFa5a5a5))
                Text(
                    text = "Message from Dr. Anushka Anand",
                    style = NonBoldH3,
                    modifier = Modifier.wrapContentSize(), // Size the text dynamically
                    maxLines = Int.MAX_VALUE, // Allow multiple lines
                    overflow = TextOverflow.Visible // Don't clip text
                )
            }

        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(y = 120.dp),

        ) {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box {
                    Image(
                        painter = painterResource(R.drawable.therapist_img1),
                        contentDescription = "",
                        Modifier.size(100.dp)
                    )
                    Box(
                        modifier = Modifier.align(Alignment.BottomEnd),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.blue_tick),
                            contentDescription = "",
                            Modifier.size(24.dp)
                        )
                        Icon(
                            Icons.Default.Check,
                            contentDescription = "",
                            tint = Color.White,
                            modifier = Modifier.size(10.dp)
                        )
                    }
                }
                Spacer(Modifier.height(8.dp))
                Text(
                    "Dr. Anushka Anand",
                    style = BoldLargeBlack,
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    "Psychologist (Counselling)",
                    style = NonBoldH2,
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    "Phd Clinical Psychology",
                    style = NonBoldH2,
                    textAlign = TextAlign.Center,
                    maxLines = 2, // Allow up to two lines for sub-speciality
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(Modifier.height(16.dp))
                AboutTherapistComposable()
            }

        }

    }

}

@Composable
fun AboutTherapistComposable(){
    Text("Hey! I am Dr. Anushka Anand, I am here to help you with everything mental health. I welcome you to bring your hopes, urges, behavioral patterns, and even the most irrelevant thoughts to this exploration of who you are,\n\nI firmly believe that our mind and emotions are powerful forces that can help us achieve goals while maintaining peace and harmony.",
        style = NonBoldH4,
        modifier = Modifier.padding(horizontal = 16.dp))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TherapistDetailsAppBar(
//    navController: NavController
) {
    TopAppBar(
        colors = TopAppBarColors(
            containerColor = Color(0XFFffffff),
            scrolledContainerColor = Color(0XFFffffff),
            navigationIconContentColor = Color(0XFFffffff),
            titleContentColor = Color(0XFFffffff),
            actionIconContentColor = Color(0XFFffffff),
        ),
//        modifier = Modifier.height(80.dp),
        title = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    "Therapist Details",
                    style = BoldH1Black,
                )
            }
        },
//        navigationIcon = {
//            Column (modifier = Modifier.fillMaxHeight(),
//                verticalArrangement = Arrangement.Center){
//                IconButton(onClick = { navController.popBackStack() }) {
//                    Icon(
//                        Icons.AutoMirrored.Filled.ArrowBack, // Replace with your back icon resource
//                        contentDescription = "Back",
//                        tint = Color.White
//                    )
//                }
//            }
//
//        }
    )
}