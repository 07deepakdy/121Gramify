package com.english.android.englishlearning.presentation.signup

sealed class SignupEvent {
    data class NameChanged(val value: String) : SignupEvent()
    data class EmailChanged(val value: String) : SignupEvent()
    data class PasswordChanged(val value: String) : SignupEvent()
    object Submit : SignupEvent()
}