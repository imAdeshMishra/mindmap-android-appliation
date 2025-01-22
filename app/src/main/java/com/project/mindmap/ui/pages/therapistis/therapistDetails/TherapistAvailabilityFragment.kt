package com.project.mindmap.ui.pages.therapistis.therapistDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.project.mindmap.R
import com.project.mindmap.ui.pages.therapistis.therapists.TherapistsFragment
import com.project.mindmap.ui.theme.BoldH2Black
import com.project.mindmap.ui.theme.BoldH3Blue
import com.project.mindmap.ui.theme.BoldH3White
import com.project.mindmap.ui.theme.BoldLargeBlack
import com.project.mindmap.ui.theme.NonBoldH2
import com.project.mindmap.ui.theme.NonBoldH2White
import com.project.mindmap.ui.theme.NonBoldH3
import com.project.mindmap.ui.theme.NonBoldH3White
import com.project.mindmap.ui.theme.NonBoldH4
import com.project.mindmap.ui.theme.NonBoldH4White

@Preview
@Composable
fun TherapistAvailabilityFragment() {
//    Column(
//    ) {
//        ModeOfCommComposable()
//        ServiceComposable()
//        AvailableSlotsComposable()
//        SlotSelectionComposable()
//    }
//    TherapistInformationFragment()
    AvailabilityFragment()
}

@Composable
fun AvailabilityFragment(){
        Column(
    ) {
        ModeOfCommComposable()
        ServiceComposable()
        AvailableSlotsComposable()
        SlotSelectionComposable()
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
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            commModes.forEach { mode ->
                CommModeContainer(selectedMode.value == mode.commMode, selectedMode, mode)
            }
        }

    }
}

@Composable
fun ServiceComposable() {
    val selectedService = remember { mutableStateOf("") }
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
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ServiceContainer(selectedService.value == "Individual", selectedService, "Individual")
            ServiceContainer(selectedService.value == "Couples", selectedService, "Couples")
            ServiceContainer(selectedService.value == "Family", selectedService, "Family")
        }
    }
}

@Composable
fun AvailableSlotsComposable() {
    val selectedDate = remember { mutableStateOf("") }
    val slotsScrollState = rememberScrollState()
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
        Row(
            modifier = Modifier.horizontalScroll(slotsScrollState),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            AvailabilitySlotContainer(selectedDate.value == "16 Apr", selectedDate, "16 Apr", 6)
            AvailabilitySlotContainer(selectedDate.value == "17 Apr", selectedDate, "17 Apr", 6)
            AvailabilitySlotContainer(selectedDate.value == "18 Apr", selectedDate, "18 Apr", 6)
            AvailabilitySlotContainer(selectedDate.value == "19 Apr", selectedDate, "19 Apr", 6)
            AvailabilitySlotContainer(selectedDate.value == "20 Apr", selectedDate, "20 Apr", 6)
            AvailabilitySlotContainer(selectedDate.value == "21 Apr", selectedDate, "21 Apr", 6)
            AvailabilitySlotContainer(selectedDate.value == "22 Apr", selectedDate, "22 Apr", 6)
        }
    }
}

@Composable
fun SlotSelectionComposable() {
    val selectedSlot = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Column(Modifier.padding(bottom = 16.dp)) {
            Text(
                "Morning",
                style = BoldH2Black
            )
            Spacer(Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                AppointmentTimingContainer(selectedSlot.value == "9:00 AM", selectedSlot, "9:00 AM")
                AppointmentTimingContainer(
                    selectedSlot.value == "10:00 AM",
                    selectedSlot,
                    "10:00 AM"
                )
                AppointmentTimingContainer(
                    selectedSlot.value == "11:00 AM",
                    selectedSlot,
                    "11:00 AM"
                )
            }
        }
        Column(Modifier.padding(bottom = 16.dp)) {
            Text(
                "Noon",
                style = BoldH2Black
            )
            Spacer(Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                AppointmentTimingContainer(
                    selectedSlot.value == "12:00 PM",
                    selectedSlot,
                    "12:00 PM"
                )
                AppointmentTimingContainer(selectedSlot.value == "1:00 PM", selectedSlot, "1:00 PM")
                AppointmentTimingContainer(selectedSlot.value == "3:00 PM", selectedSlot, "3:00 PM")
            }
        }
        Column(Modifier.padding(bottom = 16.dp)) {
            Text(
                "Evening",
                style = BoldH2Black
            )
            Spacer(Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                AppointmentTimingContainer(selectedSlot.value == "5:00 PM", selectedSlot, "5:00 PM")
                AppointmentTimingContainer(selectedSlot.value == "6:00 PM", selectedSlot, "6:00 PM")
                AppointmentTimingContainer(selectedSlot.value == "7:00 PM", selectedSlot, "7:00 PM")
            }
        }

    }
}

@Composable
fun CommModeContainer(isSelected: Boolean, selectedMode: MutableState<String>, mode: CommMode) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    Box(
        modifier = Modifier
            .width((screenWidth / 3) - 16.dp)
            .height((screenWidth / 3) - 26.dp)
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        selectedMode.value = mode.commMode
                    }
                )
            }
            .background(
                color = if (isSelected) Color(0XFF3b88e3) else Color.White,
                shape = RoundedCornerShape(16.dp)
            )
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
            Image(
                painter = if (isSelected) painterResource(mode.selectedModeImg) else painterResource(
                    mode.commModeImg
                ),
                contentDescription = mode.commMode,
            )
            Spacer(Modifier.height(8.dp))
            Text(
                mode.commMode,
                style = if (isSelected) NonBoldH4White else NonBoldH4
            )
        }
    }
}

@Composable
fun ServiceContainer(isSelected: Boolean, selectedService: MutableState<String>, service: String) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    Box(
        modifier = Modifier
            .width((screenWidth / 3) - 16.dp)
            .height(36.dp)
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        selectedService.value = service
                    }
                )
            }
            .background(
                color = if (isSelected) Color(0XFF3b88e3) else Color(0XFFf6faff),
                shape = RoundedCornerShape(16.dp)
            )
            .border(
                width = 1.dp,
                color = if (isSelected) Color.Transparent else Color(0XFF808080),
                shape = RoundedCornerShape(20.dp)
            )
            .padding(8.dp)
    ) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                service,
                style = if (isSelected) NonBoldH2White else NonBoldH2
            )
        }
    }
}

@Composable
fun AvailabilitySlotContainer(
    isSelected: Boolean,
    selectedDate: MutableState<String>,
    date: String,
    availableSlots: Int
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    Box(
        modifier = Modifier
            .width(144.dp)
            .height(98.dp)
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        selectedDate.value = date
                    }
                )
            }
            .background(
                color = if (isSelected) Color(0XFF3b88e3) else Color.White,
                shape = RoundedCornerShape(16.dp)
            )
            .border(
                width = 1.dp,
                color = if (isSelected) Color.Transparent else Color(0XFF808080),
                shape = RoundedCornerShape(20.dp)
            )
//            .padding(16.dp)
    ) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                date,
                style = if (isSelected) BoldH3White else BoldH3Blue
            )
            Spacer(Modifier.height(16.dp))
            Text(
                "$availableSlots slots available",
                style = if (isSelected) NonBoldH4White else NonBoldH4
            )
        }
    }
}

@Composable
fun AppointmentTimingContainer(
    isSelected: Boolean,
    selectedSlot: MutableState<String>,
    slot: String
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    Box(
        modifier = Modifier
            .width((screenWidth / 3) - 28.dp)
            .height(36.dp)
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        selectedSlot.value = slot
                    }
                )
            }
            .background(
                color = if (isSelected) Color(0XFF3b88e3) else Color(0XFFf6faff),
                shape = RoundedCornerShape(16.dp)
            )
            .border(
                width = 1.dp,
                color = if (isSelected) Color.Transparent else Color(0XFF808080),
                shape = RoundedCornerShape(20.dp)
            )
            .padding(8.dp)
    ) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                slot,
                style = if (isSelected) NonBoldH3White else NonBoldH3
            )
        }
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