package com.project.mindmap.ui.pages.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.project.mindmap.R
import com.project.mindmap.ui.theme.BoldH1
import com.project.mindmap.ui.theme.BoldH1Black
import com.project.mindmap.ui.theme.BoldH3Black
import com.project.mindmap.ui.theme.BoldH4
import com.project.mindmap.ui.theme.NonBoldH1
import com.project.mindmap.ui.theme.NonBoldH2
import com.project.mindmap.ui.theme.NonBoldH3
import com.project.mindmap.ui.theme.NonBoldH4
import com.project.mindmap.ui.theme.NonBoldH5
import com.project.mindmap.ui.theme.outfitFontFamily

@Composable
fun HomeScreen(navController: NavController) {
    val homeScreenState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(color = Color.White)
            .verticalScroll(homeScreenState)
    ) {
        HomeScreenTopBar()
        FeelingComposable()
        CourseModulesComposable(navController)
        TherapistComposable()
        CommunitiesComposable()
        InNewsComposable()
        TransformativeComposable()
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    val homeScreenState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(color = Color.White)
            .verticalScroll(homeScreenState)
    ) {
        HomeScreenTopBar()
        FeelingComposable()
//        CourseModulesComposable()
        TherapistComposable()
        CommunitiesComposable()
        InNewsComposable()
        TransformativeComposable()
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
                .padding(vertical = 8.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .height(80.dp),
            ) {
                Column {
                    Box(
                        modifier = Modifier
                            .padding(start = 16.dp, top = 16.dp)
                    ) {
                        Text(
                            text = "Good Morning Hiral",
                            style = BoldH1Black
                        )
                    }
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 8.dp)
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
                        .padding(end = 16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.End
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.account_holder_avatar),
                        contentDescription = "",
                        modifier = Modifier.size(120.dp)
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
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(28.dp), // Apply shape directly
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = Color.White, // Background color
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

        }
    }
}

@Composable
fun FeelingComposable() {
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text(
            text = "How are you feeling today?",
            style = NonBoldH1
        )

        Box(
            modifier = Modifier
                .padding(vertical = 16.dp)

                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = Color(0XFFe4e4e4),
                    shape = RoundedCornerShape(16.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                for (i in emojis) {
                    Box(Modifier.padding(horizontal = 12.dp, vertical = 16.dp)) {
                        Image(
                            painter = painterResource(id = i),
                            contentDescription = "",
                            Modifier.size(32.dp)
                        )
                    }

                }
            }
        }
    }
}


@Composable
fun CourseModulesComposable(navController: NavController) {
    val scrollState = rememberScrollState()

    Column() {
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .height(52.dp)
//                .background(color = Color.Yellow),
        ) {
            Column() {
                Text(
                    "Everyday Mental Health",
                    style = BoldH1Black
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    "Elevate your mental well-being",
                    style = NonBoldH2
                )
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),

                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    "See All",
                    style = TextStyle(
                        fontFamily = outfitFontFamily,
                        fontSize = 16.sp,
                        color = Color(0XFF3B88E3),
                        fontWeight = FontWeight.W500,
                    ),
                    modifier = Modifier.clickable(
                        onClick = { navController.navigate("dailyWellness") })
                )
            }
        }

        Row(
            modifier = Modifier
                .horizontalScroll(scrollState)

        ) {
            images.forEach { imageItem ->
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
fun TherapistComposable() {
    Column(
        Modifier.padding(top = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .height(44.dp)
        ) {
            Column() {
                Text(
                    "Therapists",
                    style = BoldH1Black
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    "Here for your help, care and support.",
                    style = NonBoldH2
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 16.dp)
                .height(180.dp)
        ) {
            Box {
                Image(
                    painter = painterResource(R.drawable.home_therapists_banner),
                    contentDescription = "",
                    modifier = Modifier.height(180.dp)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(vertical = 32.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Meet the Experts", style = NonBoldH5)
                Text("Explore>", style = NonBoldH5)
            }
        }
    }
}


@Composable
fun CommunitiesComposable() {
    Column(
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp)
        ) {
            Column() {
                Text(
                    "Communities",
                    style = BoldH1Black
                )

            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
        ) {
            Box {
                Image(
                    painter = painterResource(R.drawable.home_communitues_banner),
                    contentDescription = "",
                    Modifier.height(170.dp)
                )
            }
        }
        Box(modifier = Modifier.padding(horizontal = 16.dp)) {
            Text(
                "The missing piece in Mental Health",
                style = NonBoldH2
            )
        }

    }
}


@Composable
fun InNewsComposable() {
    Column(
        Modifier.padding(top = 16.dp)
    ) {
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Text(
                "In the News",
                style = BoldH1Black
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 16.dp, top = 8.dp)
                .height(140.dp)
        ) {
            Box(
                Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.home_news_banner),
                    contentDescription = "",
                    modifier = Modifier.size(180.dp)
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(vertical = 32.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "7 Life Lessons From The Movie ‘Dear Zindagi’",
                    style = NonBoldH4,
                    textAlign = TextAlign.Center
                )
                Text("Explore->", style = BoldH4)
            }
        }
        Box(modifier = Modifier.padding(horizontal = 16.dp)) {
            Row() {
                Text(
                    "23k Reads",
                    style = NonBoldH4
                )
                Spacer(Modifier.width(12.dp))
                Text(
                    "123k Likes",
                    style = NonBoldH4
                )
                Spacer(Modifier.width(12.dp))
                Text(
                    "45 Comments",
                    style = NonBoldH4
                )
            }

        }
    }
}


@Composable
fun TransformativeComposable() {
    val scrollState = rememberScrollState()
    Column(
        Modifier.padding(top = 16.dp)
    ) {
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Text(
                "Transformative Tales",
                style = BoldH1Black
            )
        }
        Row(
            modifier = Modifier
                .padding(start = 8.dp, end = 4.dp, top = 8.dp, bottom = 8.dp)
                .horizontalScroll(scrollState),
        ) {
            Image(
                painter = painterResource(R.drawable.home_transformative3),
                contentDescription = "",
                modifier = Modifier.size(100.dp)
            )
            Image(
                painter = painterResource(R.drawable.home_transformative2),
                contentDescription = "",
                modifier = Modifier.size(100.dp)
            )
            Image(
                painter = painterResource(R.drawable.home_transformative1),
                contentDescription = "",
                modifier = Modifier.size(100.dp)
            )
        }
        Box(modifier = Modifier.padding(end = 16.dp, start = 16.dp, bottom = 16.dp, top = 4.dp)) {
            Text(
                "Celebrating Healing Heroes",
                style = NonBoldH3
            )
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

data class ImageItemInfo(
    val imageRes: Int,
    val description: String,
    val title: String,
    val moduleInfo: String
)


val images = listOf(
    ImageItemInfo(
        imageRes = R.drawable.home_screen_img1,
        description = "Move-ment Mental Health",
        title = "Take a Mental Health Walk",
        moduleInfo = "7 Modules . 7 Meditations"
    ),
    ImageItemInfo(
        imageRes = R.drawable.home_screen_img2,
        description = "De - clutter your space, De - clutter your mins",
        title = "De-clutter your life",
        moduleInfo = "10 Evidence Based Tips and Tricks"
    ),
    ImageItemInfo(
        imageRes = R.drawable.home_screen_img3,
        description = "The Art of Waiting",
        title = "Practice Patience during Highs and Lows ",
        moduleInfo = "7 Modules . 10 Meditations"
    ),
    ImageItemInfo(
        imageRes = R.drawable.home_screen_img4,
        description = "Navigating Stress Storms",
        title = "Grounded Beginnings - Soaring Heights",
        moduleInfo = "8 Self Paced Modules"
    ),
    ImageItemInfo(
        imageRes = R.drawable.home_screen_img5,
        description = "Enduring Growth",
        title = "Slow Growth, Lasting Wellness",
        moduleInfo = "Free Community Access"
    ),
    ImageItemInfo(
        imageRes = R.drawable.home_screen_img6,
        description = "Embrace the Sun",
        title = "Start your day with Sunlight",
        moduleInfo = "1 Module. 180 mins"
    ),
    ImageItemInfo(
        imageRes = R.drawable.home_screen_img7,
        description = "Mindful Technology",
        title = "Navigating Digital Wellness",
        moduleInfo = "10 Evidence Based Tips and Tricks"
    ),
    ImageItemInfo(
        imageRes = R.drawable.home_screen_img8,
        description = "Balanced Diet,Balanced Mind.",
        title = "Balanced Diet and Mental Health",
        moduleInfo = "8 Self Paced Modules. 2 Live sessions"
    ),
    ImageItemInfo(
        imageRes = R.drawable.home_screen_img9,
        description = "Building Resilience",
        title = "Strengthening Your Inner Fortitude",
        moduleInfo = "6 Sessions 2 Live Sessions"
    ),
    ImageItemInfo(
        imageRes = R.drawable.home_screen_img10,
        description = "Mending Hearts",
        title = "Dealing with Heartbreak",
        moduleInfo = "8 Modules"

    ),
    ImageItemInfo(
        imageRes = R.drawable.home_screen_img11,
        description = "Mending Hearts",
        title = "Dealing with Heartbreak",
        moduleInfo = "8 Modules"
    ),
)

