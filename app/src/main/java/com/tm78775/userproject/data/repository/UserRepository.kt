package com.tm78775.userproject.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.tm78775.userproject.data.model.User
import com.tm78775.userproject.data.model.UserResponse
import com.tm78775.userproject.data.service.UserPagingSource
import com.tm78775.userproject.data.service.UserService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

/**
 * Ideally a Repository would leverage a service and a ROOM database. Due to
 * time constraints, I've only implemented fetching from a service.
 */
class UserRepository(
    private val service: UserService
) {

    /**
     * This method will fetch users from the server.
     * @return A [UserResponse] object.
     */
    fun getUsers(): Flow<PagingData<User>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                UserPagingSource(service)
            }
        ).flow
    }

    companion object {
        private const val PAGE_SIZE = 20
    }

}