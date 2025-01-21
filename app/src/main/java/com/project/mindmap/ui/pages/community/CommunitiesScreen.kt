package com.project.mindmap.ui.pages.community

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.mindmap.R
import com.project.mindmap.ui.pages.home.ImageItemInfo
import com.project.mindmap.ui.theme.BoldH1Black
import com.project.mindmap.ui.theme.BoldH2Black
import com.project.mindmap.ui.theme.BoldH2White
import com.project.mindmap.ui.theme.BoldH3Black
import com.project.mindmap.ui.theme.BoldH5Black
import com.project.mindmap.ui.theme.NonBoldH3
import com.project.mindmap.ui.theme.NonBoldH4

@Preview
@Composable
fun CommunitiesScreen(){
    Scaffold(
        Modifier.background(color = Color(0XFFf8f8f8)),
        topBar = {
            CommunitiesAppBar()
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .background(color = Color(0XFFf8f8f8))
                .padding(paddingValues)
        ) {
            SearchBox()
            CommunityGridComposable()
        }
    }
}

@Composable
fun SpotlightComposable(){
    Column (

    ){
        Box (
            modifier = Modifier
                .padding(vertical = 4.dp)
        ){
            Text("Spotlight Insights",
                style = BoldH1Black,)
        }
        Box (
            modifier = Modifier
                .padding(vertical =  16.dp)
                .shadow(
                    elevation = 2.dp,
                    shape = RoundedCornerShape(20.dp),
                    clip = false
                )
        ){
            Column (
                Modifier.background(color = Color.White)
            ){
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(16.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.community_spotlight),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(16f / 9f)
                            .clip(RoundedCornerShape(20.dp)),
                        contentScale = ContentScale.Crop
                    )

                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 16.dp)
                            .background(
                                color = Color(0XFF479bff), // Semi-transparent white background
                                shape = RoundedCornerShape(20.dp)
                            )
                            .padding(horizontal =  32.dp, vertical = 8.dp) // Inner padding for the text box
                    ) {
                        Text(
                            text = "Become a Member",
                            style = BoldH2White,
                            modifier = Modifier.wrapContentSize(), // Size the text dynamically
                            maxLines = Int.MAX_VALUE, // Allow multiple lines
                            overflow = TextOverflow.Visible // Don't clip text
                        )
                    }

//                Spacer(modifier = Modifier.height(16.dp))

                }
                Row (
                    Modifier.padding(horizontal = 16.dp)
                ){
                    Text(
                        text = "MM/Mindful Moments",
                        style = BoldH3Black,
                        modifier = Modifier.wrapContentSize(), // Size the text dynamically
                        maxLines = Int.MAX_VALUE, // Allow multiple lines
                        overflow = TextOverflow.Visible
                    )
                    Text(
                        text = " . 74K Members",
                        style = NonBoldH3,
                        modifier = Modifier.wrapContentSize(), // Size the text dynamically
                        maxLines = Int.MAX_VALUE, // Allow multiple lines
                        overflow = TextOverflow.Visible
                    )
                }
                Row (
                    Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                ){
                    Text(
                        text = "Unlocking the energy centers within for holistic well-being and spiritual growth.",
                        style = NonBoldH3,
                        modifier = Modifier.wrapContentSize(), // Size the text dynamically
                        maxLines = Int.MAX_VALUE, // Allow multiple lines
                        overflow = TextOverflow.Visible
                    )
                }
                Spacer(Modifier.height(8.dp))
            }



        }

    }

}

@Composable
fun CommunityGridComposable() {
    val spotlightIndex = 6 // Position where SpotlightComposable will appear

    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // Two items per row
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(16.dp), // Padding for the entire grid
        verticalArrangement = Arrangement.spacedBy(16.dp), // Space between rows
        horizontalArrangement = Arrangement.spacedBy(16.dp) // Space between columns
    ) {
        items(
            count = communityObjects.size + 1, // Add 1 for the SpotlightComposable
            span = { index ->
                if (index == spotlightIndex) GridItemSpan(2) else GridItemSpan(1)
            }
        ) { index ->
            when (index) {
                spotlightIndex -> {
                    // SpotlightComposable spans the entire width
                    SpotlightComposable()
                }
                else -> {
                    // Display CommunityCard for other items
                    val communityIndex = if (index > spotlightIndex) index - 1 else index
                    CommunityCard(communityObjects[communityIndex])
                }
            }
        }
    }
}

@Composable
fun CommunityCard(communityItem: ImageItemInfo) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = communityItem.imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        Column(
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Text(
                text = communityItem.title,
                style = BoldH3Black,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(Modifier.height( 4.dp))
            Text(
                text = "${communityItem.moduleInfo} members",
                style = NonBoldH4,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBox(){
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
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommunitiesAppBar(
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
                    "Communities",
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


val communityObjects = listOf(
    ImageItemInfo(
        imageRes = R.drawable.communities_img1,
        description = "",
        title = "Stress Navigators",
        moduleInfo = "23k"
    ),
    ImageItemInfo(
        imageRes = R.drawable.communities_img2,
        description = "",
        title = "Serenity Seekers",
        moduleInfo = "24k"
    ),
    ImageItemInfo(
        imageRes = R.drawable.communities_img3,
        description = "",
        title = "Anxiety Avengers",
        moduleInfo = "72k"
    ),
    ImageItemInfo(
        imageRes = R.drawable.communities_img4,
        description = "",
        title = "Mindful Moments",
        moduleInfo = "93k"
    ),
    ImageItemInfo(
        imageRes = R.drawable.communities_img5,
        description = "",
        title = "Caregivers Corners",
        moduleInfo = "47k"
    ),
    ImageItemInfo(
        imageRes = R.drawable.communities_img6,
        description = "",
        title = "Depression Defeaters",
        moduleInfo = "108k"
    ),
    ImageItemInfo(
        imageRes = R.drawable.communities_img7,
        description = "",
        title = "Dealing with Heartbreak",
        moduleInfo = "71k"
    ),
    ImageItemInfo(
        imageRes = R.drawable.communities_img8,
        description = "",
        title = "Tranquil Thoughts",
        moduleInfo = "96k"
    ),
    ImageItemInfo(
        imageRes = R.drawable.communities_img9,
        description = "",
        title = "Happiness Habour",
        moduleInfo = "408k"
    ),
    ImageItemInfo(
        imageRes = R.drawable.communities_img10,
        description = "",
        title = "Cipher Solutions",
        moduleInfo = "23k"

    ),
)