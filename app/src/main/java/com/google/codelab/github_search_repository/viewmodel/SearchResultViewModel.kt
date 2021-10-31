package com.google.codelab.github_search_repository.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.google.codelab.github_search_repository.R
import com.google.codelab.github_search_repository.model.Failure
import com.google.codelab.github_search_repository.model.QueryException
import com.google.codelab.github_search_repository.model.SearchRepositoryBusinessModel
import com.google.codelab.github_search_repository.repository.SearchDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.subjects.PublishSubject
import retrofit2.HttpException
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
class SearchResultViewModel @Inject constructor(
    private val repository: SearchDataRepository
) : ViewModel() {
    val repositoryList: PublishSubject<List<SearchRepositoryBusinessModel>> = PublishSubject.create()
    val error: PublishSubject<Failure> = PublishSubject.create()
    val keyword = ObservableField("")
    private val disposable = CompositeDisposable()

    fun fetchRepository(query: String) {
        repository.fetchRepository(query)
            .subscribeBy(
                onSuccess = { repositoryList.onNext(it) },
                onError = { error.onNext(Failure(it, it.toMessage())) }
            )
            .addTo(disposable)

        repository.getStreamQueryError()
            .subscribeBy { error.onNext(Failure(it, it.toMessage())) }
            .addTo(disposable)
    }

    private fun Throwable.toMessage(): Int {
        return when (this) {
            is HttpException -> toMessage()
            is QueryException -> R.string.error_invalid_query
            is UnknownHostException -> R.string.error_offline
            else -> R.string.error_unexpected
        }
    }

    private fun HttpException.toMessage(): Int {
        return when (code()) {
            500 -> R.string.error_message_500
            else -> R.string.error_unexpected
        }
    }


    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}
