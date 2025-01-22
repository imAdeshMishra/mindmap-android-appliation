package com.project.mindmap.ui.pages.therapistis.therapistDetails

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.flowlayout.FlowCrossAxisAlignment
import com.project.mindmap.R
import com.project.mindmap.ui.pages.elite.FAQsComposable
import com.project.mindmap.ui.theme.BoldH1Black
import com.project.mindmap.ui.theme.BoldLargeBlack
import com.project.mindmap.ui.theme.NonBoldH2
import com.project.mindmap.ui.theme.NonBoldH3
import com.project.mindmap.ui.theme.NonBoldH4
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment
import com.project.mindmap.ui.pages.home.ImageItemInfo
import com.project.mindmap.ui.theme.BoldH2
import com.project.mindmap.ui.theme.BoldH3White
import com.project.mindmap.ui.theme.NonBoldH2Blue
import kotlinx.coroutines.launch

@Composable
fun TherapistDetailsScreen(navController: NavController) {

    val pagerState = rememberPagerState(initialPage = 0, pageCount = { 2})

    Scaffold(
        Modifier.background(color = Color(0XFFf8f8f8)),
        topBar = {
            TherapistDetailsAppBar(navController)
        }
    ) { paddingValues ->
        Column (
            modifier = Modifier
                .background(color = Color.White)
        ){
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .background(color = Color.White)
                    .padding(paddingValues)
            ) {
                item { TherapistInformationComposable() }
                item { TherapistDetailFragmentIndicator(pagerState) }
                item { TherapistDetailFragments(pagerState) }
            }
            if (pagerState.currentPage==0) CheckAvailabilityButton()
        }
    }
}

@Composable
fun TherapistInformationComposable() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .background(
                    Brush.linearGradient(
                        colors = listOf(
                            Color(0xFFffdbe3),
                            Color(0xFFf4d2dd)
                        ),
                        start = Offset(0f, 0f),
                        end = Offset(0f, Float.POSITIVE_INFINITY)
                    )
                )
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
            Row(
                modifier = Modifier.padding(horizontal = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Default.PlayArrow,
                    contentDescription = "",
                    tint = Color(0XFFa5a5a5)
                )
                Text(
                    text = "Message from Dr. Anushka Anand",
                    style = NonBoldH3,
                    modifier = Modifier.wrapContentSize(),
                    maxLines = Int.MAX_VALUE,
                    overflow = TextOverflow.Visible
                )
            }

        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(y = 120.dp),

            ) {
            Column(
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
                Spacer(Modifier.height(136.dp))
            }
        }
    }
}

@Composable
fun TherapistDetailFragments(pagerState:PagerState){
    HorizontalPager(
        state = pagerState,
    ) { page ->
        when (page) {
            0 -> TherapistInformationFragment() // First page content
            1 -> TherapistAvailabilityFragment( ) // Second page content
        }
    }
}

@Composable
fun TherapistDetailFragmentIndicator(pagerState: PagerState){
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val coroutineScope = rememberCoroutineScope()
    Row {
        repeat(2) { index ->
            val isSelected = pagerState.currentPage == index

            Box (
                modifier = Modifier
                    .width(screenWidth/2)
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onTap = {
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(index)
                                }
                            })
                    }
            ){
                Column {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
//                            .background(color = Color.Yellow)
                            .padding(vertical = 8.dp),
                        contentAlignment = Alignment.Center
                    ){
                        Text(if (index==0) "Information" else "Availability",
                            style = if (isSelected) NonBoldH2Blue else  NonBoldH2)
                    }
                    Box(
                        modifier = Modifier
                            .width(screenWidth/2)
                            .height(4.dp)
                            .background(
                                color = if (isSelected) Color(0XFF69aeff) else Color(0XFFdddddd),
                                shape = RoundedCornerShape(2.dp) // Rounded edges
                            )
                    )

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TherapistDetailsAppBar(
    navController: NavController
) {
    TopAppBar(
        colors = TopAppBarColors(
            containerColor = Color(0XFFffffff),
            scrolledContainerColor = Color(0XFFffffff),
            navigationIconContentColor = Color(0XFFffffff),
            titleContentColor = Color(0XFFffffff),
            actionIconContentColor = Color(0XFFffffff),
        ),
        title = {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Therapist Details",
                    style = BoldH1Black,
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
                        tint = Color.Black
                    )
                }
            }

        }
    )
}



