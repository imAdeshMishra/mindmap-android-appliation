package com.project.mindmap.backend.network

import com.project.mindmap.backend.api.MindmapAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private var retrofit: Retrofit? = null
    private var api: MindmapAPI? = null
    private var currentBaseUrl: String? = null

    // Function to dynamically build Retrofit instance
    fun setBaseUrl(baseUrl: String) {
        if (retrofit == null || currentBaseUrl != baseUrl) {
            currentBaseUrl = baseUrl
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            api = retrofit!!.create(MindmapAPI::class.java)
        }
    }

    // Expose the API instance
    fun getAPI(): MindmapAPI {
        return api ?: throw IllegalStateException("Base URL is not set. Call setBaseUrl() first.")
    }
}

