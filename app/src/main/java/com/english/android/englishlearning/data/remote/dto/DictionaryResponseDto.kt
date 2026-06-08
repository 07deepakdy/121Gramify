package com.english.android.englishlearning.data.remote.dto

import com.english.android.englishlearning.domain.model.DictionaryWord

data class DictionaryResponseDto(
    val word: String,
    val phonetic: String?,
    val phonetics: List<PhoneticDto>,
    val meanings: List<MeaningDto>,
    val license: LicenseDto?,
    val sourceUrls: List<String>
)

data class PhoneticDto(
    val text: String?,
    val audio: String?,
    val sourceUrl: String?,
    val license: LicenseDto?
)

data class MeaningDto(
    val partOfSpeech: String,
    val definitions: List<DefinitionDto>,
    val synonyms: List<String>,
    val antonyms: List<String>
)

data class DefinitionDto(
    val definition: String,
    val example: String?,
    val synonyms: List<String>,
    val antonyms: List<String>
)

data class LicenseDto(
    val name: String,
    val url: String
)

//Mapper

fun DictionaryResponseDto.toDomain(): DictionaryWord {

    val firstMeaning = meanings.firstOrNull()

    val firstDefinition = firstMeaning
        ?.definitions
        ?.firstOrNull()

    val audioUrl = phonetics
        .firstOrNull { !it.audio.isNullOrBlank() }
        ?.audio

    return DictionaryWord(
        word = word,
        phonetic = phonetic
            ?: phonetics.firstOrNull()?.text,

        audioUrl = audioUrl,

        partOfSpeech = firstMeaning?.partOfSpeech,

        meaning = firstDefinition?.definition.orEmpty(),

        example = firstDefinition?.example,

        synonyms = when {
            firstDefinition?.synonyms?.isNotEmpty() == true ->
                firstDefinition.synonyms

            firstMeaning?.synonyms?.isNotEmpty() == true ->
                firstMeaning.synonyms

            else -> emptyList()
        },

        antonyms = when {
            firstDefinition?.antonyms?.isNotEmpty() == true ->
                firstDefinition.antonyms

            firstMeaning?.antonyms?.isNotEmpty() == true ->
                firstMeaning.antonyms

            else -> emptyList()
        }
    )
}
