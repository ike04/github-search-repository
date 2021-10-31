package com.google.codelab.github_search_repository.repository

import com.google.codelab.github_search_repository.data.RemoteData
import com.google.codelab.github_search_repository.model.Mapper
import com.google.codelab.github_search_repository.model.SearchRepositoryBusinessModel
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class SearchDataRepositoryImpl @Inject constructor(
    private val remote: RemoteData
) : SearchDataRepository {
    override fun fetchRepository(query: String): Single<List<SearchRepositoryBusinessModel>> {
        return remote.fetchRepository(query).map { Mapper.transform(it) }
    }
}
