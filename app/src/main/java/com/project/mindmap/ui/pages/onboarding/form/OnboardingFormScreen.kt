package com.project.mindmap.ui.pages.onboarding.form

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import com.project.mindmap.ui.pages.home.HomeActivity
import com.project.mindmap.ui.pages.onboarding.category.UserCategoryActivity
import com.project.mindmap.ui.theme.BoldH2
import com.project.mindmap.ui.theme.BoldH3White
import com.project.mindmap.ui.theme.NonBoldH3
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Preview
@Composable
fun OnboardingScreenComposable() {
    Scaffold(
        topBar = {
            MyAppBar()
        }
    ) { paddingValues ->

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .background(color = Color(0XFFf8f8f8))
                .padding(paddingValues), // Apply paddingValues here
            contentAlignment = Alignment.BottomCenter
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .background(color = Color(0XFFf8f8f8))
                    .padding(16.dp)
            ) {
                UserFormComposable()
            }

            ConfirmButton()
        }
    }
}


@Composable
fun UserFormComposable() {

    Column {
        Text(text = "Name", style = BoldH2)
        UserInfoField("Your Name")
        Text(text = "Phone Number", style = BoldH2)
        UserInfoField("+91 99999 99999")
        Text(text = "Gender", style = BoldH2)
        FormDropdown("Your Gender", listOf("Male", "Female", "Other"))
        Text(text = "Date of birth", style = BoldH2)
//        UserInfoField("DD//MM/YYYY")
        DatePickerDocked()
        Text(text = "Marital Status", style = BoldH2)
        FormDropdown("Marital Status", listOf("Single", "Married"))
    }
}

@Composable
fun FormDropdown(fieldType: String, options: List<String>) {
    var expanded = remember { mutableStateOf(false) }
    var selectedOption = remember { mutableStateOf("") }
    Column(modifier = Modifier.padding(vertical = 16.dp)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Color.White,
                    shape = RoundedCornerShape(16.dp)
                )
                .border(
                    width = 2.dp,
                    color = Color(0XFFe4e4e4),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(horizontal = 24.dp, vertical = 16.dp)
                .clickable { expanded.value = true },
        ) {
            Text(
                text = if (selectedOption.value.isEmpty()) fieldType else selectedOption.value,
                style = NonBoldH3
            )
            DropdownMenu(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 16.dp)
                    .fillMaxWidth()
                    .background(
                        Color.White,
//                    shape = RoundedCornerShape(16.dp)
                    ),
                expanded = expanded.value,
                onDismissRequest = { expanded.value = false }
            ) {
                options.forEach { option ->
                    DropdownMenuItem(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .background(
                                Color.White,
                                shape = RoundedCornerShape(16.dp)
                            ),
                        text = {
                            Text(
                                text = option,
                                style = NonBoldH3
                            )
                        },
                        onClick = {
                            selectedOption.value = option
                            expanded.value = false
                        }
                    )
                }
            }
        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserInfoField(hint: String) {
    Box(
        modifier = Modifier.padding(vertical = 16.dp)
    ) {
        OutlinedTextField(
            value = "",
            onValueChange = {},
            textStyle = NonBoldH3,
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Color.White,
                    shape = RoundedCornerShape(16.dp)
                )
                .border(
                    width = 2.dp,
                    color = Color(0XFFe4e4e4),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(horizontal = 8.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color(0XFF3b88e3),
            ),
            placeholder = {
                Text(
                    text = hint,
                    style = NonBoldH3
                )
            },
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppBar() {
    TopAppBar(
        title = {
            Text(text = "User Details")
        },
        actions = {
            IconButton(onClick = { /* Handle search click */ }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
                )
            }
        })
}


@Composable
fun ConfirmButton() {
    val mContext = LocalContext.current
    Box(modifier = Modifier.padding(vertical = 16.dp)) {
        Button(colors = ButtonDefaults.buttonColors(
            Color(0XFF3b88e3)
        ),
            modifier = Modifier
                .fillMaxWidth() // Makes the button fill the entire width of its parent
                .padding(horizontal = 16.dp),
            onClick = {
                mContext.startActivity(Intent(mContext, UserCategoryActivity::class.java))
            }) {
            Text(text = "Continue", style = BoldH3White)
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerDocked() {
    var showDatePicker = remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()
    val selectedDate = datePickerState.selectedDateMillis?.let {
        convertMillisToDate(it)
    } ?: ""

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        OutlinedTextField(
            value = selectedDate,
            onValueChange = { },
            label = { Text("DOB") },
            readOnly = true,
            trailingIcon = {
                IconButton(onClick = { showDatePicker.value = !showDatePicker.value }) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Select date"
                    )
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .border(
                    width = 2.dp,
                    color = Color(0XFFe4e4e4),
                    shape = RoundedCornerShape(16.dp)
                )
        )

        if (showDatePicker.value) {
            Popup(
                onDismissRequest = { showDatePicker.value = false },
                alignment = Alignment.TopStart
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = 64.dp)
                        .shadow(elevation = 4.dp)
                        .background(MaterialTheme.colorScheme.surface)
                        .border(
                            width = 2.dp,
                            color = Color(0XFFe4e4e4),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .padding(16.dp)
                ) {
                    DatePicker(
                        state = datePickerState,
                        showModeToggle = false
                    )
                }
            }
        }
    }
}

//@Composable
//fun DatePickerFieldToModal(modifier: Modifier = Modifier) {
//    var selectedDate = remember { mutableStateOf<Long?>(null) }
//    var showModal = remember { mutableStateOf(false) }
//
//    OutlinedTextField(
//        value = selectedDate.value?.let { convertMillisToDate(it) } ?: "",
//        onValueChange = { },
//        label = { Text("DOB") },
//        placeholder = { Text("MM/DD/YYYY") },
//        trailingIcon = {
//            Icon(Icons.Default.DateRange, contentDescription = "Select date")
//        },
//        modifier = modifier
//            .fillMaxWidth()
//            .pointerInput(selectedDate) {
//                awaitEachGesture {
//                    // Modifier.clickable doesn't work for text fields, so we use Modifier.pointerInput
//                    // in the Initial pass to observe events before the text field consumes them
//                    // in the Main pass.
//                    awaitFirstDown(pass = PointerEventPass.Initial)
//                    val upEvent = waitForUpOrCancellation(pass = PointerEventPass.Initial)
//                    if (upEvent != null) {
//                        showModal.value = true
//                    }
//                }
//            }
//    )
//
//    if (showModal.value) {
//        DatePickerModal(
//            onDateSelected = { selectedDate.value = it },
//            onDismiss = { showModal.value = false }
//        )
//    }
//}

fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
    return formatter.format(Date(millis))
}