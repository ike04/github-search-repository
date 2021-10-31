package com.google.codelab.github_search_repository.repository

import com.google.codelab.github_search_repository.model.SearchRepositoryBusinessModel
import io.reactivex.rxjava3.core.Single

interface SearchDataRepository {
    fun fetchRepository(query: String): Single<List<SearchRepositoryBusinessModel>>
}
