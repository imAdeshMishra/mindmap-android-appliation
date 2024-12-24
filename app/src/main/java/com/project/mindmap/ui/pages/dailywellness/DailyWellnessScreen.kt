package com.project.mindmap.ui.pages.dailywellness


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.project.mindmap.R
import com.project.mindmap.ui.pages.home.ImageItemInfo
import com.project.mindmap.ui.pages.home.images
import com.project.mindmap.ui.pages.onboarding.form.MyAppBar
import com.project.mindmap.ui.theme.BoldH1Black
import com.project.mindmap.ui.theme.BoldH1White
import com.project.mindmap.ui.theme.BoldH2Black
import com.project.mindmap.ui.theme.BoldH3Black
import com.project.mindmap.ui.theme.BoldH3White
import com.project.mindmap.ui.theme.NonBoldH4
import com.project.mindmap.ui.theme.NonBoldH5

@Composable
fun DailyWellnessScreen(navController: NavController) {
    Scaffold(
        Modifier.background(color = Color(0XFFf8f8f8)),
        topBar = {

            DailyWellnessAppBar(navController)
        }
    ){ paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .padding(paddingValues)
        ) {
            ProgramGridComposable()
        }
    }

}

@Preview
@Composable
fun DailyWellnessScreenComposable() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        ProgramGridComposable()
    }
}


@Composable
fun ProgramGridComposable() {
    Column {
        Box(modifier = Modifier.padding(start =  16.dp, top = 16.dp)) {
            Text(
                "Explore",
                style = BoldH2Black
            )
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), // Two items per row
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 8.dp),
        ) {
            items(images) { programItem ->
                ProgramCard(programItem)
            }
        }
    }

}

@Composable
fun ProgramCard(imageItem: ImageItemInfo) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        Box {
            Image(
                painter = painterResource(id = imageItem.imageRes),
                contentDescription = null,
                modifier = Modifier.size(160.dp)
            )
            Box(
                modifier = Modifier
                    .padding(top = 28.dp, start = 8.dp, end = 12.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .wrapContentSize() // Dynamically sizes the box to fit the content
                    .padding(4.dp)
            ) {
                Text(
                    text = imageItem.description,
                    style = NonBoldH5,
                    modifier = Modifier
                        .wrapContentSize(), // Ensures text size determines the box width
                    maxLines = Int.MAX_VALUE, // Allow multiple lines
                    overflow = TextOverflow.Visible // Allow overflow but don't clip text
                )
            }
        }
        Column {

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DailyWellnessAppBar(navController: NavController) {
    TopAppBar(
        colors = TopAppBarColors(
            containerColor = Color(0XFFd65696),
            scrolledContainerColor = Color(0XFFd65696),
            navigationIconContentColor = Color(0XFFd65696),
            titleContentColor = Color(0XFFd65696),
            actionIconContentColor = Color(0XFFffffff),
        ),
        modifier = Modifier.height(80.dp),
        title = {
            Column(
                modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Daily Wellness",
                    style = BoldH1White,
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    "Mental Health Day -  Everyday ",
                    style = BoldH3White,
                )
            }
        },
        navigationIcon = {
            Column (modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center){
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowBack, // Replace with your back icon resource
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
            }

        }
    )
}
