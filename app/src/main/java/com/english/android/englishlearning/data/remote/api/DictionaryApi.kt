package com.english.android.englishlearning.data.remote.api

import com.english.android.englishlearning.data.remote.dto.DictionaryResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryApi {

    @GET("api/v2/entries/en/{word}")
    suspend fun getWordMeaning(
        @Path("word") word: String
    ): List<DictionaryResponseDto>
}