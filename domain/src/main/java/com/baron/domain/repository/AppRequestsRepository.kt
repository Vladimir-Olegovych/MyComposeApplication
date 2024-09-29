package com.baron.domain.repository

import com.baron.domain.model.NetworkResponse

interface AppRequestsRepository {
    suspend fun getResponse(): NetworkResponse
}