package com.google.codelab.github_search_repository.model

import retrofit2.Response

data class SearchRepositoryBusinessModel(
    val name: String
)

object Mapper {
    fun transform(response: Response<SearchRepositoryResponse>): List<SearchRepositoryBusinessModel> {
        return response.body()?.items?.let { item ->
            item.map {
                SearchRepositoryBusinessModel(
                    name = it.name
                )
            }
        } ?: emptyList()
    }
}
