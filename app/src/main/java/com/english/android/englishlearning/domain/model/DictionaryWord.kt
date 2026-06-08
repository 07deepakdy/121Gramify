package com.english.android.englishlearning.domain.model

data class DictionaryWord(
    val word: String,
    val phonetic: String?,
    val audioUrl: String?,
    val partOfSpeech: String?,
    val meaning: String,
    val example: String?,
    val synonyms: List<String>,
    val antonyms: List<String>
)
