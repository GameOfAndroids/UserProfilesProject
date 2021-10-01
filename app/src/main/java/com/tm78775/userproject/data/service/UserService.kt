package com.tm78775.userproject.data.service

import com.tm78775.userproject.data.model.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {

    @GET("/api")
    suspend fun fetchPage(
        @Query("page")    pageNumber: Int,
        @Query("results") pageSize: Int,
        @Query("seed")    seed: String
    ): Response<UserResponse>

}