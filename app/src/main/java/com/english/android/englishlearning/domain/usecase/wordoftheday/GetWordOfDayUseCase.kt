package com.english.android.englishlearning.domain.usecase.wordoftheday

import com.english.android.englishlearning.domain.model.DictionaryWord
import com.english.android.englishlearning.domain.repository.DictionaryRepository
import java.time.LocalDate
import java.util.Calendar


class GetWordOfDayUseCase(
    private val repository: DictionaryRepository
) {

    suspend operator fun invoke(): DictionaryWord? {

        val words = repository.getAllWords()

        if (words.isEmpty()) return null


        val dayIndex =
            Calendar.getInstance()
                .get(Calendar.DAY_OF_YEAR) % words.size

        val selectedWord = words[dayIndex]

        return repository
            .getWordMeaning(selectedWord)
            .firstOrNull()
    }
}