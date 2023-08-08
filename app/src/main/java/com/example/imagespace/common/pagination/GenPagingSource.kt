package com.example.imagespace.common.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.imagespace.api.PagingConstants
import com.example.imagespace.common.EmptyPagingListException

private typealias PagingSourceCallback<T> = suspend (Int, Int) -> List<T>?

class GenPagingSource<T : GenPagingViewData>(
    private val callback: PagingSourceCallback<T>
) : PagingSource<Int, T>() {

    override fun getRefreshKey(state: PagingState<Int, T>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T> {
        val pageIndex = params.key ?: PagingConstants.INIT_PAGE

        return try {
            callback(pageIndex, params.loadSize)?.let { list ->
                val prevKey = if (pageIndex != PagingConstants.INIT_PAGE) pageIndex else null
                val nextKey = if (list.isNotEmpty()) pageIndex + 1 else null

                LoadResult.Page(
                    data = list,
                    prevKey = prevKey,
                    nextKey = nextKey
                )
            } ?: LoadResult.Error(EmptyPagingListException())
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }
}