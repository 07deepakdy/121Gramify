package com.english.android.englishlearning.domain.repository

import com.english.android.englishlearning.domain.model.DictionaryWord

interface DictionaryRepository {

    suspend fun getWordMeaning(
        word: String
    ): List<DictionaryWord>

    fun getAllWords(): List<String>
}