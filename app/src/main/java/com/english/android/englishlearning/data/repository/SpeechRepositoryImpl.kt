package com.english.android.englishlearning.data.repository

import com.english.android.englishlearning.data.recognizer.SpeechRecognizerDataSource
import com.english.android.englishlearning.domain.model.SpeechResult
import com.english.android.englishlearning.domain.repository.SpeechRepository
import kotlinx.coroutines.flow.Flow

class SpeechRepositoryImpl(
    private val dataSource: SpeechRecognizerDataSource
) : SpeechRepository {

    override fun startListening() = dataSource.start()

    override fun stopListening() = dataSource.stop()

    override fun observeResults(): Flow<SpeechResult> =
        dataSource.results()
}
