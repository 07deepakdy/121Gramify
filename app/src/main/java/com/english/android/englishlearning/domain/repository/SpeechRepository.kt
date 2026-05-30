package com.english.android.englishlearning.domain.repository

import com.english.android.englishlearning.domain.model.SpeechResult
import kotlinx.coroutines.flow.Flow

interface SpeechRepository {
    fun startListening()
    fun stopListening()
    fun observeResults(): Flow<SpeechResult>
}
