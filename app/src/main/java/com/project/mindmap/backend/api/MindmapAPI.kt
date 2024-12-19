package com.project.mindmap.backend.api

import com.project.mindmap.models.LoginCredentials
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface MindmapAPI {

    @GET("/")
    suspend fun establishConnection(): Response<Map<String, String>>

    @POST("/users/create-user")
    suspend fun createUser(@Body userCredentials: LoginCredentials): Response<Map<String, String>>


}