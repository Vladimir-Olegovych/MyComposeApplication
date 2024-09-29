package com.baron.data.repository

import com.baron.data.network.AppRequests
import com.baron.domain.model.NetworkResponse
import com.baron.domain.repository.AppRequestsRepository

class AppRequestsRepositoryImpl(private val appRequests: AppRequests): AppRequestsRepository {
    override suspend fun getResponse(): NetworkResponse {
        return appRequests.getResponse()
    }
}