package com.english.android.englishlearning.data.repository

import android.util.Log
import com.english.android.englishlearning.data.local.WordAssetDataSource
import com.english.android.englishlearning.data.remote.api.DictionaryApi
import com.english.android.englishlearning.data.remote.dto.toDomain
import com.english.android.englishlearning.domain.model.DictionaryWord
import com.english.android.englishlearning.domain.repository.DictionaryRepository

class DictionaryRepositoryImpl(
    private val api: DictionaryApi,
    private val assetDataSource: WordAssetDataSource
) : DictionaryRepository {

    override suspend fun getWordMeaning(
        word: String
    ): List<DictionaryWord> {

        return api.getWordMeaning(word)
            .map { it.toDomain() }
    }

    override fun getAllWords(): List<String> {
        return assetDataSource.getWords()
    }
}