package com.google.codelab.github_search_repository

import androidx.lifecycle.ViewModel
import com.google.codelab.github_search_repository.model.SearchRepositoryBusinessModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.subjects.PublishSubject
import javax.inject.Inject

@HiltViewModel
class SearchResultViewModel @Inject constructor(
    private val repository: SearchDataRepository
) : ViewModel() {
    val repositoryList: PublishSubject<List<SearchRepositoryBusinessModel>> = PublishSubject.create()

    fun fetchRepository() {
        repository.fetchRepository()
            .subscribeBy { repositoryList.onNext(it) }
    }
}
