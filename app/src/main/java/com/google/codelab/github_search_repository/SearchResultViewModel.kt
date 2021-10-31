package com.google.codelab.github_search_repository

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class SearchResultViewModel constructor(
    private val repository: SearchDataRepository
) : ViewModel() {
}
