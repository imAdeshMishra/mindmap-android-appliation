package com.project.mindmap.ui.pages.programs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.project.mindmap.R
import com.project.mindmap.ui.pages.home.CourseModulesComposable
import com.project.mindmap.ui.pages.home.ImageItemInfo
import com.project.mindmap.ui.theme.BoldH1Black
import com.project.mindmap.ui.theme.BoldH2White
import com.project.mindmap.ui.theme.BoldH3Black
import com.project.mindmap.ui.theme.BoldH5Black
import com.project.mindmap.ui.theme.NonBoldH3
import com.project.mindmap.ui.theme.NonBoldH4
import com.project.mindmap.ui.theme.NonBoldH5


@Composable
fun ProgramLibraryScreen(navController: NavController){
    val plScrollState = rememberScrollState()

    Scaffold(
        Modifier.background(color = Color(0XFFf8f8f8)),
        topBar = {
            ProgramLibraryAppBar()
        }
    ){ paddingValues ->
        Column (
            modifier = Modifier
                .fillMaxHeight()
                .background(color = Color(0XFFf8f8f8))
                .verticalScroll(plScrollState)
                .padding(paddingValues)
        ){
            TopBanner()
            PlSection1()
            PlSection2()
            CourseModulesComposable(navController)
            PlSection4()
        }
    }
}

@Preview
@Composable
fun ProgramLibraryScreenPreview(){
    val plScrollState = rememberScrollState()

    Scaffold(
        Modifier.background(color = Color(0XFFf8f8f8)),
        topBar = {
            ProgramLibraryAppBar()
        }
    ){ paddingValues ->
        Column (
            modifier = Modifier
                .fillMaxHeight()
                .background(color = Color(0XFFf8f8f8))
                .verticalScroll(plScrollState)
                .padding(paddingValues)
        ){
            TopBanner()
            PlSection1()
//            PlSection2()
            PlSection4()
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBanner (){
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
    ){
        Row(
            modifier = Modifier
                .padding(start = 16.dp,end = 16.dp, bottom = 16.dp)
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                textStyle = NonBoldH3,
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(28.dp), // Apply shape directly
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color(0XFFf7f7f7), // Background color
                    unfocusedBorderColor = Color.White, // Border color when not focused
                    focusedBorderColor = Color.White, // Border color when focused
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

        Box(
            modifier = Modifier
                .fillMaxWidth() // Make the box occupy the full width
                .padding(horizontal = 16.dp)
//                .background(color = Color.Blue) // Blue background for the container

        ) {
            // Full-width image
            Image(
                painter = painterResource(id = R.drawable.pl_banner1),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth() // Ensure the image takes up the full width
                    .aspectRatio(16f / 9f)
                    .clip(RoundedCornerShape(20.dp)), // Set a specific aspect ratio for the image (optional)
                contentScale = ContentScale.Crop // Scale the image to fill the box
            )

            // Text overlay on top-left of the image
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 12.dp, end = 16.dp) // Position the text within the image
                    .background(
                        color = Color.White.copy(alpha = 0.8f), // Semi-transparent white background
                        shape = RoundedCornerShape(4.dp)
                    )
                    .padding(4.dp) // Inner padding for the text box
            ) {
                Text(
                    text = "Watch Teaser - 5 Mins",
                    style = BoldH5Black,
                    modifier = Modifier.wrapContentSize(), // Size the text dynamically
                    maxLines = Int.MAX_VALUE, // Allow multiple lines
                    overflow = TextOverflow.Visible // Don't clip text
                )
            }

            Box(
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp) // Position the text within the image
                    .background(
                        color = Color.White.copy(alpha = 0.8f), // Semi-transparent white background
                        shape = RoundedCornerShape(4.dp)
                    )
                    .padding(4.dp) // Inner padding for the text box
            ) {
                Text(
                    text = "Navigating Stress Storms",
                    style = BoldH5Black,
                    modifier = Modifier.wrapContentSize(), // Size the text dynamically
                    maxLines = Int.MAX_VALUE, // Allow multiple lines
                    overflow = TextOverflow.Visible // Don't clip text
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }

    }
}

@Composable
fun PlSection1(){
    val scrollState = rememberScrollState()

    Column() {
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp)
//                .height(52.dp)
//                .background(color = Color.Yellow),
        ) {
            Column(modifier = Modifier.padding(top = 16.dp)) {
                Text(
                    "Mental Mojo",
                    style = BoldH1Black
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    "Informative Brain Chemistry Workshops",
                    style = NonBoldH4
                )
            }

        }

        Row(
            modifier = Modifier
                .horizontalScroll(scrollState)

        ) {
            plSection1Images.forEach { imageItem ->
                Column {
                    Box(
                        modifier = Modifier
                            .padding(start = 16.dp)

                    ) {
                        Image(
                            painter = painterResource(id = imageItem.imageRes),
                            contentDescription = null,
                            modifier = Modifier
                                .size(160.dp)
                        )
                        Box(
                            modifier = Modifier
                                .padding(top = 28.dp, start = 8.dp)
                                .background(
                                    color = Color.White,
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .padding(4.dp)
                        ) {
                            Text(
                                text = imageItem.description,
                                style = NonBoldH5,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .widthIn(max = 120.dp), // Constrains the box width to max 120
                                maxLines = Int.MAX_VALUE, // Allow multiple lines
                                overflow = TextOverflow.Visible // Allow overflow but don't clip text
                            )
                        }


                    }
                    Column(
                        modifier = Modifier
                            .padding(start = 16.dp)
                    ) {
                        Text(
                            imageItem.title,
                            style = BoldH3Black,
                            modifier = Modifier
                                .fillMaxWidth()
                                .widthIn(max = 140.dp),
                            maxLines = Int.MAX_VALUE, // Allow multiple lines
                            overflow = TextOverflow.Visible
                        )
                        Spacer(Modifier.height(4.dp))
                        Text(
                            imageItem.moduleInfo,
                            style = NonBoldH4,
                            modifier = Modifier
                                .fillMaxWidth()
                                .widthIn(max = 140.dp),
                            maxLines = Int.MAX_VALUE, // Allow multiple lines
                            overflow = TextOverflow.Visible
                        )
                    }

                }


            }
        }
    }
}

@Composable
fun PlSection2(){
    val scrollState = rememberScrollState()

    Column() {
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp)
//                .height(52.dp)
//                .background(color = Color.Yellow),
        ) {
            Column(
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 12.dp)
            ) {
                Text(
                    "Program Categories",
                    style = BoldH1Black
                )
                Spacer(Modifier.height(4.dp))
            }
        }

        Row(
            modifier = Modifier
                .horizontalScroll(scrollState)

        ) {
            plSection2Content.forEach { contentItem ->
                Column {
                    Box(
                        modifier = Modifier
                            .padding(start = 16.dp)

                    ) {
                        Box (modifier = Modifier
                            .height(88.dp)
                            .width(140.dp)
                            .background(contentItem.backGroundColor,
                                shape = RoundedCornerShape(12.dp))
                            .padding(16.dp),
                            contentAlignment = Alignment.Center){
                            Text(
                                text = contentItem.description,
                                style = BoldH2White,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .widthIn(max = 120.dp), // Constrains the box width to max 120
                                maxLines = Int.MAX_VALUE, // Allow multiple lines
                                textAlign = TextAlign.Center,
                                overflow = TextOverflow.Visible // Allow overflow but don't clip text
                            )
                        }

                    }
                    Column(
                        modifier = Modifier
                            .padding(start = 16.dp, top = 8.dp, bottom = 16.dp)
                    ) {

                        Text(
                            contentItem.resourcesCount,
                            style = NonBoldH4,
                            modifier = Modifier
                                .fillMaxWidth()
                                .widthIn(max = 140.dp),
                            maxLines = Int.MAX_VALUE, // Allow multiple lines
                            overflow = TextOverflow.Visible
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun PlSection4(){
    val scrollState = rememberScrollState()

    Column() {
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp)
//                .height(52.dp)
//                .background(color = Color.Yellow),
        ) {
            Column(modifier = Modifier.padding(top = 16.dp)) {
                Text(
                    "My List",
                    style = BoldH1Black
                )
            }

        }

        Row(
            modifier = Modifier
                .horizontalScroll(scrollState)

        ) {
            plSection4Images.forEach { imageItem ->
                Column {
                    Box(
                        modifier = Modifier
                            .padding(start = 16.dp)

                    ) {
                        Image(
                            painter = painterResource(id = imageItem.imageRes),
                            contentDescription = null,
                            modifier = Modifier
                                .size(160.dp),
                        )
                        Box(
                            modifier = Modifier
                                .padding(top = 28.dp, start = 8.dp)
                                .background(
                                    color = Color.White,
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .padding(4.dp)
                        ) {
                            Text(
                                text = imageItem.description,
                                style = NonBoldH5,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .widthIn(max = 120.dp), // Constrains the box width to max 120
                                maxLines = Int.MAX_VALUE, // Allow multiple lines
                                overflow = TextOverflow.Visible // Allow overflow but don't clip text
                            )
                        }


                    }
                    Column(
                        modifier = Modifier
                            .padding(start = 16.dp)
                    ) {
                        Text(
                            imageItem.title,
                            style = BoldH3Black,
                            modifier = Modifier
                                .fillMaxWidth()
                                .widthIn(max = 140.dp),
                            maxLines = Int.MAX_VALUE, // Allow multiple lines
                            overflow = TextOverflow.Visible
                        )
                        Spacer(Modifier.height(4.dp))
                        Text(
                            imageItem.moduleInfo,
                            style = NonBoldH4,
                            modifier = Modifier
                                .fillMaxWidth()
                                .widthIn(max = 140.dp),
                            maxLines = Int.MAX_VALUE, // Allow multiple lines
                            overflow = TextOverflow.Visible
                        )
                    }

                }


            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProgramLibraryAppBar(
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
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal =  4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = R.drawable.pl_img1),
                    contentDescription = "",
                    modifier = Modifier.size(32.dp)
                )
                Text(
                    "Program Library",
                    style = BoldH1Black,
                )
                Image(
                    painter = painterResource(id = R.drawable.account_holder_avatar),
                    contentDescription = "",
                    modifier = Modifier.size(60.dp)
                        .padding(top = 8.dp)
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

val plSection1Images = listOf(
    ImageItemInfo(
        imageRes = R.drawable.pl_s1_img1,
        description = "The Neuron Connection",
        title = "Mental Health and Nervous System",
        moduleInfo = "8 Self Paced Modules"
    ),
    ImageItemInfo(
        imageRes = R.drawable.pl_s1_img2,
        description = "Accept Uncertainty",
        title = "Understanding Intrusive Thoughts",
        moduleInfo = "7 Modules "
    ),
    ImageItemInfo(
        imageRes = R.drawable.pl_s1_img3,
        description = " Intricacies of OCD",
        title = "In-depth insights into the nature of OCD",
        moduleInfo = "7 Modules . 10 Meditations"
    ),
    ImageItemInfo(
        imageRes = R.drawable.pl_s1_img4,
        description = "Compassionate Connections",
        title = "Navigating Mental Health Together",
        moduleInfo = "8 Modules . 10 Meditations"
    ),
    ImageItemInfo(
        imageRes = R.drawable.pl_s1_img5,
        description = "Mind - Body Connection",
        title = "Exploring the Mind - Body Connection",
        moduleInfo = "8 Modules . 10 Meditations"
    ),
)

val plSection2Content = listOf(
    PlSection2Object(
        description = "Everyday Mental Health",
        backGroundColor = Color(0XFFd65696),
        resourcesCount ="234 Resources"
    ),
    PlSection2Object(
        description = "Depression",
        backGroundColor = Color(0XFFc14747),
        resourcesCount ="234 Resources"
    ),
    PlSection2Object(
        description = "Stress and Anxiety",
        backGroundColor = Color(0XFF0e3f79),
        resourcesCount ="234 Resources"
    ),
    PlSection2Object(
        description = "Dealing with loss and grief",
        backGroundColor = Color(0XFFffc75b),
        resourcesCount ="234 Resources"
    ),
    PlSection2Object(
        description = "Coping Strategies",
        backGroundColor = Color(0XFFe8696c),
        resourcesCount ="234 Resources"
    ),
    PlSection2Object(
        description = "Building Resilience",
        backGroundColor = Color(0XFF1f844a),
        resourcesCount ="234 Resources"
    ),
    PlSection2Object(
        description = "Understanding OCD",
        backGroundColor = Color(0XFF3f53b9),
        resourcesCount ="234 Resources"
    ),
    PlSection2Object(
        description = "Adult ADHD",
        backGroundColor = Color(0XFF518f8f),
        resourcesCount ="234 Resources"
    ),
)

val plSection4Images = listOf(
    ImageItemInfo(
        imageRes = R.drawable.pl_s1_img5,
        description = "Craving Control",
        title = "Strengthening Your Inner Fortitude",
        moduleInfo = "5 Self - Paced Exercises"
    ),
    ImageItemInfo(
        imageRes = R.drawable.home_screen_img3,
        description = "The Art of Waiting",
        title = "Practice Patience during Highs and Lows ",
        moduleInfo = "7 Modules . 10 Meditations"
    ),
    ImageItemInfo(
        imageRes = R.drawable.home_screen_img6,
        description = "Embrace the Sun",
        title = "Start your day with Sunlight",
        moduleInfo = "1 Module. 180 mins"
    ),
    ImageItemInfo(
        imageRes = R.drawable.home_screen_img10,
        description = "Mending Hearts",
        title = "Dealing with Heartbreak",
        moduleInfo = "8 Modules"
    ),
)

data class PlSection2Object(
    val description: String,
    val backGroundColor: Color,
    val resourcesCount: String
)
