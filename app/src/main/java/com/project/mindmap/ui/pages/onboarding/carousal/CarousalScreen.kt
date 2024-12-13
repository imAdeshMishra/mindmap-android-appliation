package com.project.mindmap.ui.pages.onboarding.carousal

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.mindmap.R
import com.project.mindmap.ui.pages.login.LoginActivity
import com.project.mindmap.ui.pages.onboarding.form.RequirementFormActivity
import com.project.mindmap.ui.theme.BoldH1Black
import com.project.mindmap.ui.theme.BoldH2
import com.project.mindmap.ui.theme.BoldH3White
import com.project.mindmap.ui.theme.outfitFontFamily

@Preview
@Composable
fun CarousalScreen() {
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { pages.size })

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .weight(1f)
        ) { page ->
            CarousalItem(pages[page])
        }
        PageIndicator(pagerState)
        ContinueButton()
    }
}

@Composable
fun PageIndicator(pagerState: PagerState) {
    Row {
        repeat(pages.size) { index ->
            val isSelected = pagerState.currentPage == index
            Box(modifier = Modifier
                .padding(4.dp)
                .width(if (isSelected) 18.dp else 8.dp)
                .height(if (isSelected) 8.dp else 8.dp)
                .border(
                    width = 1.dp, color = Color(0xFF707784),
                    shape = RoundedCornerShape(10.dp)
                )
                .background(
                    color = if (isSelected) Color(0XFF3b88e3)
                    else Color(0xFFFFFFFF), shape = CircleShape
                )
            )
        }
    }
}

val pages = listOf(
    OnBoardModel(
        title = "Welcome to ",
        title2 = "Heal Haven",
        description = "Your one stop solution to all your emotional needs",
        imageRes = R.drawable.carousal_image1
    ),
    OnBoardModel(
        title = "Comprehensive Emotional Health",
        title2 = "",
        description = "Our team of exports has assisted nearly 12,000 individuals in enhancing their emotional well being",
        imageRes = R.drawable.carousal_image2
    ),
    OnBoardModel(
        title = "Diverse Program Library",
        title2 = "",
        description = "Delve into a diverse collection of over 3000 informative, self - paced Programs",
        imageRes = R.drawable.carousal_image3
    ),
    OnBoardModel(
        title = "Community Support",
        title2 = "",
        description = "Connect with like-minded individuals and find solace in our supportive community.",
        imageRes = R.drawable.carousal_image4
    )
)


@Composable
fun CarousalItem(page: OnBoardModel){
    Box (
        modifier = Modifier
            .background(color = Color.White)
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row (modifier = Modifier
                .padding(vertical = 20.dp)){
                Text(text = page.title,
                    style = BoldH1Black)
                Text(text = page.title2,
                    style = TextStyle(
                        fontFamily = outfitFontFamily,
                        fontSize = 18.sp,
                        color = Color(0XFFf85278),
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            Image(painter = painterResource(id = page.imageRes),
                contentDescription = "",
                Modifier.size(240.dp)
            )

            Box (
                modifier = Modifier
                    .padding(
                        horizontal = 16.dp,
                        vertical = 20.dp
                    )
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Text(text = page.description,
                    style = BoldH2,
                    textAlign = TextAlign.Center)
            }

        }
    }
}


@Composable
fun ContinueButton(){
    val mContext = LocalContext.current
    Box(modifier = Modifier.padding(vertical = 16.dp)){
        Button( colors = ButtonDefaults.buttonColors(
            Color(0XFF3b88e3)
        ),
            modifier = Modifier
                .fillMaxWidth() // Makes the button fill the entire width of its parent
                .padding(horizontal = 16.dp),
            onClick = {
                mContext.startActivity(Intent(mContext, LoginActivity::class.java))
            }) {
            Text(text = "Continue", style = BoldH3White)
        }
    }
}

data class OnBoardModel(
    val imageRes: Int,
    val title: String,
    val title2: String,
    val description: String
)
