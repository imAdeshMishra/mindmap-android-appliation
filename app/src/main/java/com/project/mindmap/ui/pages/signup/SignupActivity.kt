package com.project.mindmap.ui.pages.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.activity.viewModels
import com.project.mindmap.viewmodel.UserViewModel


class SignupActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val userViewModel: UserViewModel by viewModels()


        setContent {
            SignupScreenComposable(viewModel = userViewModel)

        }
    }
}