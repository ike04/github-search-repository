package com.google.codelab.github_search_repository

import com.google.codelab.github_search_repository.model.SearchRepositoryBusinessModel
import io.reactivex.rxjava3.core.Single

interface SearchDataRepository {
    fun fetchRepository(): Single<List<SearchRepositoryBusinessModel>>
}
