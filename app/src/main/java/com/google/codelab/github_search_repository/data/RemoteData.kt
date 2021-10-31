package com.google.codelab.github_search_repository.data

import com.google.codelab.github_search_repository.data.ApiRequest
import com.google.codelab.github_search_repository.model.SearchRepositoryResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import javax.inject.Inject

class RemoteData @Inject constructor(
    private val api: ApiRequest
) {
    fun fetchRepository(query: String): Single<Response<SearchRepositoryResponse>>{
        return api.fetchRepository(query, 1)
    }
}
