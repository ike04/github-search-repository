package com.google.codelab.github_search_repository.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.codelab.github_search_repository.R
import com.google.codelab.github_search_repository.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = this.getString(R.string.view_search_result)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, SearchResultFragment.newInstance())
            .commit()
    }
}
