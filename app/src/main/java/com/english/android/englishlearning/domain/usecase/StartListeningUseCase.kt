package com.english.android.englishlearning.domain.usecase

import com.english.android.englishlearning.domain.repository.SpeechRepository

class StartListeningUseCase(
    private val repository: SpeechRepository
) {
    operator fun invoke() = repository.startListening()
}
