package com.english.android.englishlearning.domain.usecase

import com.english.android.englishlearning.domain.model.SpeechResult
import com.english.android.englishlearning.domain.repository.SpeechRepository
import kotlinx.coroutines.flow.Flow

class ObserveSpeechResultUseCase(
    private val repository: SpeechRepository
) {
    operator fun invoke(): Flow<SpeechResult> =
        repository.observeResults()
}
