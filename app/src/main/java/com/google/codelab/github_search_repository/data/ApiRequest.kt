package com.google.codelab.github_search_repository.data

import com.google.codelab.github_search_repository.model.SearchRepositoryResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRequest {
    @GET("/search/repositories")
    fun fetchRepository(
        @Query("q") q: String,
        @Query("page") page: Int
    ): Single<Response<SearchRepositoryResponse>>

}
