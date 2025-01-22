package com.project.mindmap.ui.pages.therapistis.therapistDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowCrossAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment
import com.project.mindmap.R
import com.project.mindmap.ui.pages.elite.FAQsComposable
import com.project.mindmap.ui.pages.home.ImageItemInfo
import com.project.mindmap.ui.theme.BoldH2
import com.project.mindmap.ui.theme.BoldH3White
import com.project.mindmap.ui.theme.BoldLargeBlack
import com.project.mindmap.ui.theme.NonBoldH3
import com.project.mindmap.ui.theme.NonBoldH4

@Preview
@Composable
fun TherapistInformationFragment() {
    Column(
    ) {
        AboutTherapistComposable()
        AffiliationsComposable()
        CoreServicesComposable()
        TherapistScopesComposable()
        TherapistLanguagesComposable()
        FAQsComposable(therapistFAQs)
//        CheckAvailabilityButton()
    }


}

@Composable
fun AboutTherapistComposable() {
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        "Hey! I am Dr. Anushka Anand, I am here to help you with everything mental health. I welcome you to bring your hopes, urges, behavioral patterns, and even the most irrelevant thoughts to this exploration of who you are,\n\nI firmly believe that our mind and emotions are powerful forces that can help us achieve goals while maintaining peace and harmony.",
        style = NonBoldH4,
        modifier = Modifier.padding(horizontal = 16.dp)
    )
}

@Composable
fun AffiliationsComposable() {

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(
            "Affiliations",
            style = BoldLargeBlack
        )
        Spacer(Modifier.height(16.dp))
        FlowRow(
            modifier = Modifier
                .fillMaxWidth(),
            mainAxisSpacing = 16.dp, // Spacing between items in the same row
            crossAxisSpacing = 8.dp, // Spacing between rows
            mainAxisAlignment = MainAxisAlignment.Start, // Align items to the start
            crossAxisAlignment = FlowCrossAxisAlignment.Start // Align rows to the start
        ) {
            therapistAffiliations.forEach { affiliation ->
                AffiliationContainer(affiliation = affiliation)
            }
        }
    }


}

@Composable
fun CoreServicesComposable() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(
            "Core Services",
            style = BoldLargeBlack
        )
        Spacer(Modifier.height(16.dp))
        FlowRow(
            modifier = Modifier
                .fillMaxWidth(),
            mainAxisSpacing = 8.dp, // Spacing between items in the same row
            crossAxisSpacing = 8.dp, // Spacing between rows
            mainAxisAlignment = MainAxisAlignment.Start, // Align items to the start
            crossAxisAlignment = FlowCrossAxisAlignment.Start // Align rows to the start
        ) {
            coreServices.forEach { service ->
                CoreServiceContainer(service = service)
            }
        }
    }

}

@Composable
fun TherapistScopesComposable() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(
            "Scope of Practice",
            style = BoldLargeBlack
        )
        Spacer(Modifier.height(16.dp))
        Column(
            modifier = Modifier
                .padding(horizontal = 8.dp)
        ) {
            scopeOfPractice.forEach { scope ->
                Row(Modifier.padding(vertical = 2.dp)) {
                    Text(
                        text = "•", // Unicode bullet point
                        style = BoldH2,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        scope,
                        style = NonBoldH3
                    )
                }
            }
        }
    }
}

@Composable
fun TherapistLanguagesComposable() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(
            "Languages I speak",
            style = BoldLargeBlack
        )
        Spacer(Modifier.height(16.dp))
        Text(
            "English, Hindi, Punjabi ",
            style = NonBoldH3
        )
    }
}

@Composable
fun AffiliationContainer(affiliation: ImageItemInfo) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    Box(
        modifier = Modifier
            .width((screenWidth / 2) - 28.dp)
            .background(color = Color.White, shape = RoundedCornerShape(16.dp))
            .border(
                width = 1.dp,
                color = Color(0XFF808080),
                shape = RoundedCornerShape(20.dp)
            )
            .padding(16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(affiliation.imageRes),
                contentDescription = ""
            )
            Spacer(Modifier.width(8.dp))
            Text(
                "${affiliation.description} ${affiliation.title}",
                style = NonBoldH4
            )
        }
    }
}

@Composable
fun CoreServiceContainer(service: String) {

    Box(
        modifier = Modifier
            .padding(2.dp)
            .height(32.dp)
            .background(color = Color.White, shape = RoundedCornerShape(16.dp))
            .border(
                width = 1.dp,
                color = Color(0XFF808080),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(8.dp)
    ) {
        Text(
            service,
            style = NonBoldH3
        )
    }
}

@Composable
fun CheckAvailabilityButton() {
    Box(modifier = Modifier.padding(vertical = 8.dp)) {
        Button(colors = ButtonDefaults.buttonColors(
            Color(0XFF3b88e3)
        ),
            modifier = Modifier
                .fillMaxWidth() // Makes the button fill the entire width of its parent
                .padding(horizontal = 16.dp),
            onClick = {
//                navController.navigate("userCategory")
            }
        ) {
            Text(text = "Check Availability", style = BoldH3White)
        }
    }
}

val therapistFAQs = listOf(
    "How do i find the right therapist?",
    "How do i prepare for my first therapist session?",
)

val coreServices = listOf(
    "Child and Adolescent Services",
    "Psychoanalysis",
    "Counselling (Trauma)",
    "Psychotherapy (CBT)",
    "Individual and Couple Therapy",
    "Counselling"
)

val scopeOfPractice = listOf(
    "Abuse",
    "Addiction",
    "Anger Management Issues",
    "Anxiety Disorders",
    "Behavioural and Emotional Problems",
    "Depression",
    "Mental Health",
    "Obsessions and Compulsions (OCD)",
    "Relationship Counselling",
    "Trauma"
)

val therapistAffiliations = listOf(
    ImageItemInfo(
        title = "Delhi University",
        description = "Phd in Clinical Psychology from ",
        imageRes = R.drawable.therapist_detail_img1,
        moduleInfo = ""
    ),
    ImageItemInfo(
        title = "(LPC)",
        description = "Licensed Professional Counselor ",
        imageRes = R.drawable.therapist_detail_img2,
        moduleInfo = ""
    ),
)