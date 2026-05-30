package com.english.android.englishlearning.domain.usecase

import com.english.android.englishlearning.domain.repository.AuthRepository

class SignupUseCase(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(name: String, email: String, password: String): Result<Unit> {
        return repository.signup(name, email, password)
    }
}
