package com.baron.mycomposeapplication.di

import com.baron.data.network.AppRequests
import com.baron.data.network.AppRequests.Companion.TIMEOUT
import com.baron.data.network.AppRequests.Companion.URL
import com.baron.data.repository.AppRequestsRepositoryImpl
import com.baron.domain.repository.AppRequestsRepository
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
        .callTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
        .readTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
        .writeTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .build()

    @Provides
    @Singleton
    fun provideAppRequests(retrofit: Retrofit): AppRequests =
        retrofit.create(AppRequests::class.java)

    @Provides
    @Singleton
    fun provideAppRequestsRepository(appRequests: AppRequests): AppRequestsRepository =
        AppRequestsRepositoryImpl(appRequests = appRequests)
}