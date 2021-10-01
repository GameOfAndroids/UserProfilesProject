package com.tm78775.userproject.di

import com.tm78775.userproject.data.repository.UserRepository
import com.tm78775.userproject.data.service.ApiClient
import com.tm78775.userproject.data.service.UserPagingSource
import com.tm78775.userproject.data.service.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @Provides
    @ViewModelScoped
    fun provideUserRepository(): UserRepository {
        val client = ApiClient
            .getApiClient()
            .create(UserService::class.java)

        return UserRepository(client)
    }

    @Provides
    @ViewModelScoped
    fun provideUserPagingSource(): UserPagingSource {
        val client = ApiClient
            .getApiClient()
            .create(UserService::class.java)

        return UserPagingSource(client)
    }

}