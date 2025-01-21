package com.project.mindmap.ui.pages.therapistis.therapistDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.mindmap.R
import com.project.mindmap.ui.theme.BoldLargeBlack
import com.project.mindmap.ui.theme.NonBoldH4
import com.project.mindmap.ui.theme.NonBoldH4White

@Preview
@Composable
fun TherapistAvailabilityFragment() {
    Column(modifier = Modifier.background(color = Color.White)) {
        ModeOfCommComposable()
        ServiceComposable()
        AvailableSlotsComposable()
    }
}

@Composable
fun ModeOfCommComposable() {
    val selectedMode = remember { mutableStateOf(commModes[0].commMode) }
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(
            "Mode of Communication",
            style = BoldLargeBlack
        )
        Spacer(Modifier.height(16.dp))
        commModes.forEach{mode->
            CommModeContainer(selectedMode.value==mode.commMode,selectedMode,mode)
        }
    }
}

@Composable
fun CommModeContainer(isSelected:Boolean, selectedMode: MutableState<String>,mode: CommMode) {
    Box(
        modifier = Modifier
            .width(112.dp)
            .height(96.dp)
            .background(color = if (isSelected) Color(0XFF3b88e3) else Color.White,
                shape = RoundedCornerShape(16.dp))
            .border(
                width = 1.dp,
                color = if (isSelected) Color.Transparent else Color(0XFF808080),
                shape = RoundedCornerShape(20.dp)
            )
            .padding(16.dp)
    ) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(painter = if (isSelected) painterResource(mode.selectedModeImg) else painterResource(mode.commModeImg),
                contentDescription = mode.commMode,)
            Text(mode.commMode,
                style = if (isSelected) NonBoldH4White else NonBoldH4)
        }
    }
}

@Composable
fun ServiceComposable() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(
            "Select your Service",
            style = BoldLargeBlack
        )
        Spacer(Modifier.height(16.dp))
    }
}

@Composable
fun AvailableSlotsComposable() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(
            "Check Available Slots",
            style = BoldLargeBlack
        )
        Spacer(Modifier.height(16.dp))
    }
}

val commModes = listOf(
    CommMode(
        commMode = "Audio Call",
        commModeImg = R.drawable.icon_phone,
        selectedModeImg = R.drawable.icon_phone_selected,
    ),
    CommMode(
        commMode = "Video Call",
        commModeImg = R.drawable.icon_video,
        selectedModeImg = R.drawable.icon_video_selected,
    ),
    CommMode(
        commMode = "In - Person",
        commModeImg = R.drawable.icon_clinic,
        selectedModeImg = R.drawable.icon_clinic_selected,
    ),
)

data class CommMode(
    val commMode: String,
    val selectedModeImg: Int,
    val commModeImg: Int,
)