package com.baron.data.network

import com.baron.domain.model.NetworkResponse
import retrofit2.http.GET

interface AppRequests {

    @GET("daily_json.js")
    suspend fun getResponse(): NetworkResponse

    companion object {
        const val URL = "https://www.cbr-xml-daily.ru"
        const val TIMEOUT: Long = 10000
    }
}