package com.project.mindmap.ui.pages.therapistis.therapists

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.project.mindmap.ui.theme.BoldH2Black
import com.project.mindmap.ui.theme.NonBoldH2
import kotlinx.coroutines.launch

@Composable
fun TherapistsScreen(navController: NavController) {

    val pagerState = rememberPagerState(initialPage = 0, pageCount = { 2 })

    Scaffold(
        Modifier.background(color = Color(0XFFf8f8f8)),
        topBar = {
            TherapistFragmentIndicator(pagerState)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .background(color = Color(0XFFf8f8f8))
                .padding(paddingValues)
        ) {

            TherapistScreenFragments(pagerState, navController)
        }
    }
}


@Composable
fun TherapistScreenFragments(pagerState: PagerState, navController: NavController) {
    HorizontalPager(
        state = pagerState,
    ) { page ->
        when (page) {
            0 -> TherapistsGridComposable(navController) // First page content
            1 -> TherapistAppointmentsFragment(navController) // Second page content
        }
    }
}

@Composable
fun TherapistFragmentIndicator(pagerState: PagerState) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val coroutineScope = rememberCoroutineScope()
    Row {
        repeat(2) { index ->
            val isSelected = pagerState.currentPage == index

            Box(
                modifier = Modifier
                    .width(screenWidth / 2)
                    .background(color = Color.White)
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onTap = {
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(index)
                                }
                            })
                    }
            ) {
                Column {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            if (index == 0) "Therapists" else "Appointments",
                            style = if (isSelected) BoldH2Black else NonBoldH2
                        )
                    }
                    Box(
                        modifier = Modifier
                            .width((screenWidth / 2))
                            .padding(horizontal = 20.dp)
                            .height(4.dp)
                            .background(
                                color = if (isSelected) Color(0XFF69aeff) else Color.White,
                                shape = RoundedCornerShape(2.dp) // Rounded edges
                            )
                    )
                    Spacer(Modifier.height(12.dp))
                }
            }
        }
    }
}
