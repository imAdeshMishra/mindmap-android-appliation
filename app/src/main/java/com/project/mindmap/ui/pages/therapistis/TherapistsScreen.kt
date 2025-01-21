package com.project.mindmap.ui.pages.therapistis

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.mindmap.R
import com.project.mindmap.ui.theme.BoldH1Black
import com.project.mindmap.ui.theme.BoldH3Black
import com.project.mindmap.ui.theme.NonBoldH3
import com.project.mindmap.ui.theme.NonBoldH4
import com.project.mindmap.ui.theme.NonBoldH4Underline

@Preview
@Composable
fun TherapistsScreen() {

    Scaffold(
        Modifier.background(color = Color(0XFFf8f8f8)),
        topBar = {
            TherapistsAppBar()
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .background(color = Color.White)
                .padding(paddingValues)
        ) {
            TherapistsGridComposable()
        }
    }
}


//@Preview
@Composable
fun TherapistsGridComposable() {
    Column {

        LazyVerticalGrid(
            columns = GridCells.Fixed(2), // Two items per row
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 8.dp),
        ) {
            items(therapistsList) { therapist ->
                TherapistCard(therapist)
            }
        }
    }
}

@Composable
fun TherapistCard(therapist: TherapistInfo) {
    Box(
        modifier = Modifier
            .height(280.dp)
            .padding(8.dp)
            .shadow(
                elevation = 2.dp, // Adjust the elevation to control the shadow intensity
                shape = RoundedCornerShape(20.dp),
                clip = false
            )
    ) {
        Column(
            modifier = Modifier
                .background(
                    color = Color(0XFFffffff),
                    shape = RoundedCornerShape(20.dp)
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(6.0f)
                    .background(
                        color = Color(0XFFf6faff),
                        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                    )
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box {
                    Image(
                        painter = painterResource(therapist.profileAvatar),
                        contentDescription = "",
                        Modifier.size(80.dp)
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
                    therapist.therapistName,
                    style = BoldH3Black,
                    textAlign = TextAlign.Center,
                    maxLines = 1, // Limit to one line if needed
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    therapist.speciality,
                    style = NonBoldH4,
                    textAlign = TextAlign.Center,
                    maxLines = 1, // Limit to one line if needed
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    therapist.subSpeciality,
                    style = NonBoldH4,
                    textAlign = TextAlign.Center,
                    maxLines = 2, // Allow up to two lines for sub-speciality
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    "View Profile",
                    style = NonBoldH4Underline
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .weight(1.0f)
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row {
                    Box(
                        modifier = Modifier
                            .height(16.dp)
                            .width(16.dp)
                            .background(
                                color = Color(0XFFa9d060),
                                shape = RoundedCornerShape(8.dp)
                            )
                    )
                    Spacer(Modifier.width(4.dp))
                    Text(
                        "Available",
                        style = NonBoldH3
                    )
                }
                Icon(
                    Icons.Outlined.Info,
                    contentDescription = "",
                    tint = Color(0XFF808080),
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TherapistsAppBar(
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
//                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    "Therapists",
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

val therapistsList = listOf(
    TherapistInfo(
        therapistName = "Ms. Anushka Anand",
        profileAvatar = R.drawable.therapist_img1,
        availability = "Available",
        speciality = "Psychologist (Counselling)",
        subSpeciality = "Clinical Psychologist",
    ),
    TherapistInfo(
        therapistName = "Dr. Raunak Sharma",
        profileAvatar = R.drawable.therapist_img2,
        availability = "Available",
        speciality = "Clinical Psychologist",
        subSpeciality = "Hypnotherapist",
    ), TherapistInfo(
        therapistName = "Ms. Navya Arora",
        profileAvatar = R.drawable.therapist_img3,
        availability = "Available",
        speciality = "M.sc Clinical Psychology",
        subSpeciality = "Psychologist (Counselling)",
    ), TherapistInfo(
        therapistName = "Ms. Steffy Sachdeva",
        profileAvatar = R.drawable.therapist_img4,
        availability = "Available",
        speciality = "Psychotherapist",
        subSpeciality = "Counselor",
    ), TherapistInfo(
        therapistName = "Ms.Shilpa Peringala",
        profileAvatar = R.drawable.therapist_img5,
        availability = "Available",
        speciality = "Clinical Psychologist ",
        subSpeciality = "Hypnotherapist",
    ), TherapistInfo(
        therapistName = "Ms. Ananya Bajaj",
        profileAvatar = R.drawable.therapist_img5,
        availability = "Available",
        speciality = "Clinical Psychologist ",
        subSpeciality = "CBT Psychotherapist",
    ), TherapistInfo(
        therapistName = "Ms. Tenzin Dolma",
        profileAvatar = R.drawable.therapist_img6,
        availability = "Available",
        speciality = "Psychologist",
        subSpeciality = "CBT Psychotherapist",
    ), TherapistInfo(
        therapistName = "Dr. Jahangir Khan",
        profileAvatar = R.drawable.therapist_img7,
        availability = "Available",
        speciality = "Psychologist (Counselling)",
        subSpeciality = "Relationship Therapist",
    ), TherapistInfo(
        therapistName = "Dr. Karan Sharma",
        profileAvatar = R.drawable.therapist_img8,
        availability = "Available",
        speciality =
        "Clinical Psychologist",
        subSpeciality = "Counselor",
    ), TherapistInfo(
        therapistName = "Mr. Nikhil Khanna",
        profileAvatar = R.drawable.therapist_img9,
        availability = "Available",
        speciality = "Psychologist (Counselling)",
        subSpeciality = "Clinical Psychologist ",
    ), TherapistInfo(
        therapistName = "Dr. Arhsan Khan",
        profileAvatar = R.drawable.therapist_img10,
        availability = "Available",
        speciality = "Counselling Psychologist",
        subSpeciality = "Marriage and Family Therapist",
    ), TherapistInfo(
        therapistName = "Dr. Yashwant Velankar",
        profileAvatar = R.drawable.therapist_img11,
        availability = "Available",
        speciality = "Industrial Psychologist",
        subSpeciality = "Psychologist (Counselling)",
    ), TherapistInfo(
        therapistName = "Dr. Richa Khanna",
        profileAvatar = R.drawable.therapist_img12,
        availability = "Available",
        speciality = "Psychologist (Counselling)",
        subSpeciality = "Trained Clinical Supervisor",
    ),
    TherapistInfo(
        therapistName = "Ms. Khushi Awasthi",
        profileAvatar = R.drawable.therapist_img6,
        availability = "Available",
        speciality = "Psychologist",
        subSpeciality = "CBT Psychotherapist",
    )
)


data class TherapistInfo(
    val therapistName: String,
    val profileAvatar: Int,
    val speciality: String,
    val subSpeciality: String,
    val availability: String,

    )