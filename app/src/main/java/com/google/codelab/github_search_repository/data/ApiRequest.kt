package com.google.codelab.github_search_repository.data

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRequest {
    @GET("/search/repositories")
    suspend fun fetchRepository(
        @Query("q") q: String,
        @Query("page") page: Int
    ): SearchRepositoryResponse

}
