package com.google.codelab.github_search_repository.model

data class SearchRepositoryResponse(
    val items: List<RepositoryResponse>
)

data class RepositoryResponse(
    val id: Int,
    val name: String
)
