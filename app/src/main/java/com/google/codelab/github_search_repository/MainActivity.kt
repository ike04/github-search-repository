package com.google.codelab.github_search_repository

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.codelab.github_search_repository.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
    }
}
