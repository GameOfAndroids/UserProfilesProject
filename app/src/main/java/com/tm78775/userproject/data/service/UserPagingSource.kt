package com.tm78775.userproject.data.service

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.tm78775.userproject.data.model.User

class UserPagingSource(
    private val service: UserService
) : PagingSource<Int, User>() {

    private val pageSize = 10
    private val seed = "foobar"

    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        val pageIndex = params.key ?: START_INDEX

        return try {
            service.fetchPage(
                pageIndex,
                pageSize,
                seed
            ).body().let {
                val nextKey = if(it == null) null else pageIndex + 1
                LoadResult.Page(
                    data = it?.results ?: listOf(),
                    prevKey = if(pageIndex == START_INDEX) null else pageIndex,
                    nextKey = nextKey
                )
            }
        } catch (exception: Exception) {
            // todo: log exception in crash recording tool.
            LoadResult.Error(exception)
        }
    }

    companion object {
        private const val START_INDEX = 1
    }
}