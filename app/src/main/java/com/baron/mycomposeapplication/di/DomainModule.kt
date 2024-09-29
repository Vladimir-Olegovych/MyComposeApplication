package com.baron.mycomposeapplication.di

import com.baron.domain.repository.AppRequestsRepository
import com.baron.domain.usecase.AppRequestsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {
    @Provides
    fun provideAppRequestsUseCase(appRequestsRepository: AppRequestsRepository): AppRequestsUseCase =
        AppRequestsUseCase(appRequestsRepository = appRequestsRepository)
}