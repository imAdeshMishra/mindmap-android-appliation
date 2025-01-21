package com.project.mindmap.ui.pages.elite

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.mindmap.R
import com.project.mindmap.ui.pages.home.ImageItemInfo
import com.project.mindmap.ui.theme.BoldH1Black
import com.project.mindmap.ui.theme.BoldH2Black
import com.project.mindmap.ui.theme.BoldH2White
import com.project.mindmap.ui.theme.BoldH3Black
import com.project.mindmap.ui.theme.BoldH3White
import com.project.mindmap.ui.theme.BoldLargeBlack
import com.project.mindmap.ui.theme.NonBoldH3
import com.project.mindmap.ui.theme.NonBoldH3Black
import com.project.mindmap.ui.theme.NonBoldH3White
import com.project.mindmap.ui.theme.outfitFontFamily

@Composable
fun EliteScreen() {
    val plScrollState = rememberScrollState()

    Scaffold(
        Modifier.background(color = Color(0XFFf8f8f8)),
        topBar = {
            EliteScreenAppBar()
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .background(color = Color(0XFFf8f8f8))
                .verticalScroll(plScrollState)
                .padding(paddingValues)
        ) {
            TopBanner()
            ElitePlansComposable()
            EliteBenefitsComposable()
            FAQsComposable(eliteFAQs)
            EliteHelpComposable()
        }
    }
}

@Preview
@Composable
fun EliteScreenPreview() {
    val plScrollState = rememberScrollState()

    Scaffold(
        Modifier.background(color = Color(0XFFf8f8f8)),
        topBar = {
            EliteScreenAppBar()
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .background(color = Color(0XFFf8f8f8))
                .verticalScroll(plScrollState)
                .padding(paddingValues)
        ) {
            TopBanner()
            ElitePlansComposable()
            EliteBenefitsComposable()
            FAQsComposable(eliteFAQs)
            EliteHelpComposable()
        }
    }
}

@Composable
fun TopBanner() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth() // Make the box occupy the full width
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.Center

        ) {

            Image(
                painter = painterResource(id = R.drawable.elite_banner1),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f)
                    .clip(RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(
                        color = Color(0X4F111111),
                        shape = RoundedCornerShape(20.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "MINDMAP Elite",
                        style = TextStyle(
                            fontFamily = outfitFontFamily,
                            color = Color.White,
                            fontSize = 32.sp,
                            fontWeight = FontWeight(800)
                        ),
                        modifier = Modifier.wrapContentSize(), // Size the text dynamically
                        maxLines = Int.MAX_VALUE, // Allow multiple lines
                        overflow = TextOverflow.Visible // Don't clip text
                    )
                    Text(
                        text = "Your One Stop Mental Health Destination",
                        style = BoldH3White,
                        modifier = Modifier.wrapContentSize(), // Size the text dynamically
                        maxLines = Int.MAX_VALUE, // Allow multiple lines
                        overflow = TextOverflow.Visible // Don't clip text
                    )
                }

            }


            Spacer(modifier = Modifier.height(16.dp))
        }

    }
}

@Composable
fun ElitePlansComposable() {
    val selectedPlan = remember { mutableIntStateOf(1) }

    Column(Modifier.padding(horizontal = 16.dp)) {
        for (i in 1..3) {
            Box(modifier = Modifier.padding(top = 16.dp)) {
                ElitePlan(i, i == selectedPlan.intValue, selectedPlan)
            }

        }
    }
}

@Composable
fun EliteBenefitsComposable() {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp)

    ) {
        Column(Modifier.padding(top = 16.dp)) {
            Text(
                "Upgrade to Elite ",
                style = BoldLargeBlack
            )
            Spacer(Modifier.height(4.dp))
            Text(
                "Your emotional well - being journey begins here!",
                style = NonBoldH3
            )
        }
        Column {
            for (benefit in eliteBenefitsList) {
                Box(modifier = Modifier.padding(top = 16.dp)) {
                    EliteBenefit(benefit)
                }

            }
        }
    }
}

@Composable
fun FAQsComposable(questions: List<String>) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(
            "FAQs",
            style = BoldLargeBlack
        )
        Spacer(Modifier.height(16.dp))
        Row(
            modifier = Modifier.horizontalScroll(scrollState),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            val i = 1
            questions.forEach { question ->
                FAQContainer(i.toString(), question)
            }
        }
    }
}

@Composable
fun ElitePlan(planIndex: Int, isSelected: Boolean, selectedPlan: MutableState<Int>) {
    Box(
        modifier = Modifier
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    if (selectedPlan.value != planIndex) selectedPlan.value = planIndex
                })
            }
            .background(
                color = if (isSelected) Color(0XFF3b88e3) else Color(0XFFf6faff),
                shape = RoundedCornerShape(20.dp)
            )
            .padding(vertical = 16.dp, horizontal = 20.dp),

        ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "Monthly",
                    style = if (isSelected) BoldH2White else BoldH2Black
                )
                Text(
                    "₹ 199",
                    style = if (isSelected) BoldH2White else BoldH2Black
                )
            }
            Spacer(Modifier.height(4.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "Unlock everything for a month",
                    style = if (isSelected) NonBoldH3White else NonBoldH3Black
                )
                Text(
                    "Billed annually",
                    style = if (isSelected) BoldH3White else BoldH3Black
                )
            }
        }
    }
}

@Composable
fun EliteBenefit(benefit: ImageItemInfo) {
    Row(
        Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(20.dp),
                    clip = true,
                    spotColor = Color(0xFF747272),
                    ambientColor = Color(0xFF747272)
                )
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(vertical = 8.dp, horizontal = 24.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(benefit.imageRes),
                contentDescription = "",
                Modifier
                    .size(64.dp)
                    .background(color = Color.White)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        // Right Text Column
        Column(
            modifier = Modifier
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                benefit.title,
                style = BoldH2Black
            )
            Text(
                benefit.description,
                style = NonBoldH3,
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Composable
fun FAQContainer(index: String, question: String) {
    Box(
        modifier = Modifier
            .width(180.dp)
            .height(80.dp)
            .background(
                color = Color(0XFFf6faff),
                shape = RoundedCornerShape(12.dp)
            )
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Top
        ) {
            Text(
                "${index}.",
                style = NonBoldH3
            )
            Spacer(Modifier.width(4.dp))
            Text(
                question,
                style = NonBoldH3,
                maxLines = 2,
            )
        }

    }
}

@Composable
fun EliteHelpComposable() {
    Column {
        Spacer(Modifier.height(16.dp))
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                "Have feedback or questions? Write to us!",
                style = NonBoldH3
            )
        }
        Spacer(Modifier.height(16.dp))
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                "Terms and Conditions | Privacy Policy",
                style = NonBoldH3
            )
        }
        Spacer(Modifier.height(16.dp))
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                "Restore Purchase",
                style = NonBoldH3
            )
        }
    }
}

val eliteBenefitsList = listOf(
    ImageItemInfo(
        imageRes = R.drawable.elite_img1,
        title = "Enhanced Community Access :",
        description = "Exclusive access to premium community groups led by expert therapists, fostering more personalized discussions and support.",
        moduleInfo = ""
    ),
    ImageItemInfo(
        imageRes = R.drawable.elite_img2,
        title = "Elaborate Content Library",
        description = "A growing library of activities, tools, resources, and mental health materials from renowned mental health professionals.",
        moduleInfo = ""
    ),
    ImageItemInfo(
        imageRes = R.drawable.elite_img3,
        title = "Personalized Progress Tracking",
        description = "Access to detailed progress tracking tools and recommendations based on your journey within the app.",
        moduleInfo = ""
    ),
    ImageItemInfo(
        imageRes = R.drawable.elite_img4,
        title = "Priority Scheduling",
        description = " Enjoy priority scheduling for therapy sessions and other services, ensuring prompt support when you need it most.",
        moduleInfo = ""
    ),


    )

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EliteScreenAppBar(
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
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pl_img1),
                    contentDescription = "",
                    modifier = Modifier.size(32.dp)
                )
                Text(
                    "MM Elite",
                    style = BoldH1Black,
                )
                Image(
                    painter = painterResource(id = R.drawable.account_holder_avatar),
                    contentDescription = "",
                    modifier = Modifier
                        .size(60.dp)
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


val eliteFAQs = listOf(
    "Can I update my subscription?",
    "Are EMI options available",
    "How do I cancel my subscription?"
)