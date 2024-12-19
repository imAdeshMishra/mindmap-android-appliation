package com.project.mindmap.ui.pages.onboarding.form

import android.content.Intent
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.mindmap.R
import com.project.mindmap.ui.pages.home.HomeActivity
import com.project.mindmap.ui.theme.BoldH1Black
import com.project.mindmap.ui.theme.BoldH2
import com.project.mindmap.ui.theme.BoldH3White

@Preview
@Composable
fun FormScreen(){
    Column(
        modifier = Modifier
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        Text(text = "What are you here for?",
            style = BoldH1Black)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "I am here to...",
            style = BoldH2)
        Spacer(modifier = Modifier.height(16.dp))
        Column (modifier = Modifier
            .weight(1f)
            .padding(horizontal = 16.dp)){
            for (element in options) {
                FormItem(element)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
        ContinueButton()
    }
}


@Composable
fun FormItem(itemInfo: FormItemInfo){
    Box (
        modifier = Modifier
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    itemInfo.isSelected.value = !itemInfo.isSelected.value
                })
            }
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = if (itemInfo.isSelected.value) Color(0XFF3b88e3)
                else Color(0XFFe8dcdc), // Border color
                shape = RoundedCornerShape(20.dp) // Border radius
            )
            .height(52.dp)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ){
        Row (modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically){
            Image(painter = painterResource(id = itemInfo.imageRes),
                contentDescription = "",
                Modifier.size(40.dp))
            Text(text = itemInfo.title,
                style = BoldH2)
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
                mContext.startActivity(Intent(mContext, HomeActivity::class.java))
            }) {
            Text(text = "Continue", style = BoldH3White)
        }
    }
}


val options = listOf(
    FormItemInfo(
        title = "Regulate Daily Wellness",
        imageRes = R.drawable.form_icon1,
        isSelected = mutableStateOf(value = false)
    ),
    FormItemInfo(
        title = "Manage Stress",
        imageRes = R.drawable.form_icon2,
        isSelected = mutableStateOf(value = false)
    ),
    FormItemInfo(
        title = "Navigate Anxiety",
        imageRes = R.drawable.form_icon3,
        isSelected = mutableStateOf(value = false)
    ),
    FormItemInfo(
        title = "Deal with Depression",
        imageRes = R.drawable.form_icon4,
        isSelected = mutableStateOf(value = false)
    ),
    FormItemInfo(
        title = "Mental Health Conditons",
        imageRes = R.drawable.form_icon5,
        isSelected = mutableStateOf(value = false)
    ),
    FormItemInfo(
        title = "Navigating Loss and Grief",
        imageRes = R.drawable.form_icon6,
        isSelected =  mutableStateOf(value = false)
    ),
    FormItemInfo(
        title = "Relationship Struggles ",
        imageRes = R.drawable.form_icon7,
        isSelected = mutableStateOf(value = false)
    )
)

data class FormItemInfo(
    val imageRes : Int,
    val title: String,
    val isSelected: MutableState<Boolean>
)