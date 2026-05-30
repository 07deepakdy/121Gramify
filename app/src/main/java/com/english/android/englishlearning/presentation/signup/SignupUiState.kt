package com.english.android.englishlearning.presentation.signup

data class SignupUiState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val loading: Boolean = false,
    val signupSuccess: Boolean = false,
    val errorMessage: String? = null,
    val message: String? = null
) {
    val isFormValid: Boolean
        get() = name.isNotBlank() && email.isNotBlank() && password.length >= 6
}
