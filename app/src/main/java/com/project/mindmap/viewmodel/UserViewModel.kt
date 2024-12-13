package com.project.mindmap.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.mindmap.backend.network.RetrofitInstance
import com.project.mindmap.models.LoginCredentials
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class UserViewModel : ViewModel() {

    fun createUser(
        userCredentials: LoginCredentials,
        onResponse: (Map<String, String>?, String?) -> Unit
    ) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.getAPI().createUser(userCredentials)
                if (response.isSuccessful) {
                    // Handle success response
                    onResponse(response.body(), null)
                } else {
                    // Handle error response
                    onResponse(null, "Error: ${response.code()}")
                }
            } catch (e: HttpException) {
                onResponse(null, "HttpException: ${e.message()}")
            } catch (e: IOException) {
                onResponse(null, "IOException: ${e.message}")
                Log.d("MINDMAP","IOException: ${e.message}")
            }
        }
    }
}