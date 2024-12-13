package com.project.mindmap.ui.pages.onboarding.form

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable

class RequirementFormActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RequirementFormScreen()
        }
    }
}

@Composable
fun RequirementFormScreen(){
    FormScreen()
}