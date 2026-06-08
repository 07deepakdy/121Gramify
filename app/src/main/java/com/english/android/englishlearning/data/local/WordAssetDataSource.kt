package com.english.android.englishlearning.data.local

import android.content.Context
import com.english.android.englishlearning.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class WordAssetDataSource(
    private val context: Context
) {

    private data class WordEntry(val id: Int, val word: String)

    private var cachedWords: List<String>? = null

    fun getWords(): List<String> {

        cachedWords?.let { return it }

        val json = context.resources
            .openRawResource(R.raw.words_with_id)
            .bufferedReader()
            .use { it.readText() }

        val wordEntries: List<WordEntry> = Gson().fromJson(
            json,
            object : TypeToken<List<WordEntry>>() {}.type
        )

        cachedWords = wordEntries.map { it.word }

        return cachedWords!!
    }
}
