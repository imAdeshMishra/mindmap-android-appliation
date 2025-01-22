package com.project.mindmap.ui.pages.onboarding.form

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.navigation.NavController
import com.project.mindmap.ui.theme.BoldH1Black
import com.project.mindmap.ui.theme.BoldH2
import com.project.mindmap.ui.theme.BoldH3White
import com.project.mindmap.ui.theme.NonBoldH3
import com.project.mindmap.ui.theme.PurpleGrey80
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun OnboardingScreenComposable(navController: NavController) {
    Scaffold(
        Modifier.background(color = Color(0XFFf8f8f8)),
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

            ConfirmButton(navController)
        }
    }
}


@Composable
fun UserFormComposable() {
    var name by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var dob by remember { mutableStateOf("") }
    var maritalStatus by remember { mutableStateOf("") }
    Column {
        Text(text = "Name", style = BoldH2)
        UserInfoField("Your Name", name) { name = it }
        Text(text = "Phone Number", style = BoldH2)
        UserInfoField("+91 99999 99999", phoneNumber) { phoneNumber = it }
        Text(text = "Gender", style = BoldH2)
        FormDropdown("Gender", listOf("Male", "Female", "Other"))
        Text(text = "Date of birth", style = BoldH2)
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
                .clickable {
                    expanded.value = !expanded.value // Toggle the dropdown visibility
                }
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 16.dp),
                text = selectedOption.value.ifEmpty { fieldType },
                style = NonBoldH3
            )
        }

        DropdownMenu(
            expanded = expanded.value,
            onDismissRequest = { expanded.value = false }, // Close the dropdown when clicked outside
            modifier = Modifier
                .fillMaxWidth() // Match the width of the parent
                .background(
                    color = PurpleGrey80

                )
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = option,
                            style = NonBoldH3
                        )
                    },
                    onClick = {
                        selectedOption.value = option
                        expanded.value = false // Close the dropdown after selection
                    }
                )
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserInfoField(hint: String, value: String, onValueChange: (String) -> Unit) {
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
                focusedIndicatorColor = Color.Transparent,
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
        colors = TopAppBarColors(
            containerColor = Color(0XFFf8f8f8),
            scrolledContainerColor = Color(0XFFf8f8f8),
            navigationIconContentColor = Color(0XFFf8f8f8),
            titleContentColor = Color(0XFFf8f8f8),
            actionIconContentColor = Color(0XFFf8f8f8),
        ),
        title = {
            Text(text = "User Details", style = BoldH1Black)
        },
    )
}


@Composable
fun ConfirmButton(navController: NavController) {
    val mContext = LocalContext.current
    Box(modifier = Modifier.padding(vertical = 16.dp)) {
        Button(colors = ButtonDefaults.buttonColors(
            Color(0XFF3b88e3)
        ),
            modifier = Modifier
                .fillMaxWidth() // Makes the button fill the entire width of its parent
                .padding(horizontal = 16.dp),
            onClick = {
                navController.navigate("userCategory")
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

    val backgroundColor = Color(0XFFF5EEF6)
    val borderColor = Color(0XFFF0E3F3)
    val textColor = Color.Black // Set a color that works well in both modes

    Box(
        modifier = Modifier.padding(vertical = 16.dp)
    ) {
        OutlinedTextField(
            value = selectedDate,
            onValueChange = {},
            textStyle = NonBoldH3.copy(color = textColor),
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
            readOnly = true,
            trailingIcon = {
                IconButton(onClick = { showDatePicker.value = !showDatePicker.value }) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Select date",
                        tint = textColor
                    )
                }
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color(0XFF3b88e3),
            ),
            placeholder = {
                Text(
                    text = "DD/MM/YYYY",
                    style = NonBoldH3.copy(color = textColor)
                )
            },
        )

        if (showDatePicker.value) {
            Popup(
                onDismissRequest = { showDatePicker.value = false },
                alignment = Alignment.Center,
            ) {
                Box(
                    modifier = Modifier
                        .padding(32.dp)
                        .border(
                            width = 2.dp,
                            color = borderColor,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .background(
                            color = backgroundColor,
                            shape = RoundedCornerShape(16.dp)
                        )
                ) {
                    Column {
                        DatePicker(
                            state = datePickerState,
                            showModeToggle = false,
                            colors = DatePickerDefaults.colors(
                                containerColor = backgroundColor,
                                titleContentColor = textColor,
                                headlineContentColor = textColor,
                                dayContentColor = textColor,
                                selectedDayContentColor = Color.White,
                                selectedDayContainerColor = Color(0XFF3b88e3)
                            )
                        )
                        Box(
                            modifier = Modifier
                                .padding(16.dp)
                        ) {
                            Button(
                                onClick = {
                                    showDatePicker.value = false // Close the popup
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0XFF3b88e3),
                                    contentColor = Color.White
                                )
                            ) {
                                Text("Confirm")
                            }
                        }
                    }
                }
            }
        }
    }
}


fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
    return formatter.format(Date(millis))
}
