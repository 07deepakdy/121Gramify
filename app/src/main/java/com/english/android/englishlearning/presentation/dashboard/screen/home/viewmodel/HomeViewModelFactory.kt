package com.english.android.englishlearning.presentation.dashboard.screen.home.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.english.android.englishlearning.data.local.WordAssetDataSource
import com.english.android.englishlearning.data.remote.api.RetrofitClient
import com.english.android.englishlearning.data.repository.DictionaryRepositoryImpl
import com.english.android.englishlearning.domain.usecase.wordoftheday.GetWordOfDayUseCase

class HomeViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            val api = RetrofitClient.api
            val assetDataSource = WordAssetDataSource(context)
            val repository = DictionaryRepositoryImpl(api, assetDataSource)
            val getWordOfDayUseCase = GetWordOfDayUseCase(repository)
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(getWordOfDayUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
