package com.project.mindmap.ui.pages.onboarding.category

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.mindmap.R
import com.project.mindmap.ui.pages.onboarding.carousal.OnboardingCarousalActivity
import com.project.mindmap.ui.pages.onboarding.form.RequirementFormActivity
import com.project.mindmap.ui.theme.BoldH1Black
import com.project.mindmap.ui.theme.BoldH2
import com.project.mindmap.ui.theme.BoldH3White
import com.project.mindmap.ui.theme.outfitFontFamily


@Composable
fun CategoryScreen(selectedCategory: MutableState<Int>,context: Context){

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier =  Modifier.background(color = Color.White)) {
        Text(text = "What are you here for?",
            style = BoldH1Black)
        Spacer(modifier = Modifier.height(44.dp))
        Row (
            modifier = Modifier
                .padding(16.dp)
            ,verticalAlignment = Alignment.CenterVertically
        ){
            Column (
                Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Box(
                    modifier = Modifier
                        .pointerInput(Unit) {
                            detectTapGestures(onTap = {
                                if (selectedCategory.value == 2) selectedCategory.value = 1
                            })
                        }
                        .border(
                            width = 2.dp,
                            color = if (selectedCategory.value == 1) Color(0xFFF16161)
                            else Color(0XFFe8dcdc),
                            shape = RoundedCornerShape(16.dp) // Border radius
                        )
                        .background(
                            color = if (selectedCategory.value == 1) Color(0xFFF894AB)
                            else Color.White,
                            shape = RoundedCornerShape(16.dp)
                        )


                        .height(180.dp)
                        .width(140.dp)
                        ,
                    contentAlignment = Alignment.Center,

                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        ) {
                        Box (modifier= Modifier
                            .clip(CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(painter = painterResource(id = R.drawable.category_image1),
                                contentDescription = "",
                                modifier = Modifier.size(60.dp)
                            )
                        }

                        Box(
                            modifier = Modifier
                                .padding(vertical = 12.dp)
                        ) {
                            Text(text = "HEAL HAVEN",
                                style = TextStyle(
                                    fontFamily = outfitFontFamily,
                                    color = if (selectedCategory.value ==1) Color.White else Color(0xFFF16161)

                                )
                            )
                        }

                    }

                }
                Box(
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .fillMaxWidth()
                    ,
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = "You are here to Heal",
                        style = TextStyle(
                            fontFamily = outfitFontFamily,
                            fontSize = 16.sp,
                            color = if (selectedCategory.value == 1) Color(0xFFF16161)
                            else Color(0XFFe8dcdc),

                            )
                    )
                }

            }

            Column (
                Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Box(
                    modifier = Modifier
                        .pointerInput(Unit) {
                            detectTapGestures(
                                onTap = {
                                if (selectedCategory.value == 1) {
                                    selectedCategory.value = 2
                                }
                                    Toast.makeText(context,"Category coming soon",Toast.LENGTH_SHORT).show()
                            })
                        }
                        .border(
                            width = 2.dp,
                            color = if (selectedCategory.value == 2) Color(0xFF4ea126)
                            else Color(0XFFe8dcdc), // Border color
                            shape = RoundedCornerShape(16.dp) // Border radius
                        )
                        .background(
                            color = if (selectedCategory.value == 2) Color(0xFF84cc79) else Color.White,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .height(180.dp)
                        .width(140.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,

                    ) {
                        Box (modifier= Modifier
                            .clip(CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(painter = painterResource(id = R.drawable.category_image2),
                                contentDescription = "",
                                modifier = Modifier.size(60.dp)
                            )
                        }

                        Box(
                            modifier = Modifier
                                .padding(vertical = 16.dp)
                        ) {
                            Text(text = "GROWTH  GARDEN",
                                style = TextStyle(
                                    fontFamily = outfitFontFamily,
                                    color = if (selectedCategory.value ==2) Color.White else Color(0XFF4ea126)

                                )
                            )
                        }


                    }
                }
                Box(
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .fillMaxWidth()
                    ,
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = "You are here to Grow",
                        style = TextStyle(
                            fontFamily = outfitFontFamily,
                            fontSize = 16.sp,
                            color =  if (selectedCategory.value == 2) Color(0xFF84cc79)  else Color(0XFFe8dcdc),

                            )
                    )
                }

            }
        }
        Spacer(modifier = Modifier.height(44.dp))
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
            ,
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Your needs might change often, and so can your path.",
                style = BoldH2,
                textAlign = TextAlign.Center
            )
        }

    }
}



@Composable
fun ContinueButton(selectedCategory: MutableState<Int>){
    val buttonColor = when (selectedCategory.value) {
        1 -> Color(0xFF3B88E3)  // Blue color for selectedCategory 1
        2 -> Color(0xFF949494)  // Green color for selectedCategory 2
        else -> Color(0xFF949494)  // Default blue color
    }
    val mContext = LocalContext.current
    Box(modifier = Modifier.padding(vertical = 16.dp)){

        Button( colors = ButtonDefaults.buttonColors(
            buttonColor
        ),
            modifier = Modifier
                .fillMaxWidth() // Makes the button fill the entire width of its parent
                .padding(horizontal = 16.dp),
            onClick = {
                mContext.startActivity(Intent(mContext, RequirementFormActivity::class.java))
            }) {
            Text(text = "Continue", style = BoldH3White)
        }
    }
}
