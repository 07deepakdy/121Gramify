package com.english.android.englishlearning.domain.usecase

import com.english.android.englishlearning.domain.repository.SpeechRepository

class StopListeningUseCase(
    private val repository: SpeechRepository
) {
    operator fun invoke() = repository.stopListening()
}
