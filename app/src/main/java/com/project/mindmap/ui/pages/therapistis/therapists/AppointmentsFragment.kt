package com.project.mindmap.ui.pages.therapistis.therapists

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun TherapistAppointmentsFragment(navController: NavController) {
    TherapistsGridComposable(navController)
}