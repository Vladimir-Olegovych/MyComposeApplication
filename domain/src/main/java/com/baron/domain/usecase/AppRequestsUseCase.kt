package com.baron.domain.usecase

import com.baron.domain.model.NetworkResponse
import com.baron.domain.repository.AppRequestsRepository

class AppRequestsUseCase(private val appRequestsRepository: AppRequestsRepository) {

    suspend fun getResponse(): NetworkResponse =
        appRequestsRepository.getResponse()

}