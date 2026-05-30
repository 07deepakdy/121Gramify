package com.english.android.englishlearning.data.recognizer

import com.english.android.englishlearning.domain.model.SpeechResult
import kotlinx.coroutines.flow.Flow

interface SpeechRecognizerDataSource {
    fun start()
    fun stop()
    fun results(): Flow<SpeechResult>
}
