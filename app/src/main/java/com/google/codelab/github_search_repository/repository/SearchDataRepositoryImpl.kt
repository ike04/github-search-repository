package com.google.codelab.github_search_repository.repository

import com.google.codelab.github_search_repository.data.RemoteData
import com.google.codelab.github_search_repository.model.Mapper
import com.google.codelab.github_search_repository.model.QueryException
import com.google.codelab.github_search_repository.model.SearchRepositoryBusinessModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.subjects.PublishSubject
import javax.inject.Inject

class SearchDataRepositoryImpl @Inject constructor(
    private val remote: RemoteData
) : SearchDataRepository {
    val queryError: PublishSubject<Throwable> = PublishSubject.create()

    override fun fetchRepository(query: String): Single<List<SearchRepositoryBusinessModel>> {
        return remote.fetchRepository(query)
            .doOnSuccess {
                if (it.code() == 422) {
                    queryError.onNext(QueryException())
                }
            }
            .map { Mapper.transform(it) }
    }

    override fun getStreamQueryError(): Observable<Throwable> = queryError.hide()
}
