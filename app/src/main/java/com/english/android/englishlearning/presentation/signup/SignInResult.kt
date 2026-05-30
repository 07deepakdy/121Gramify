package com.english.android.englishlearning.presentation.signup

import com.google.firebase.auth.FirebaseUser

sealed class SignInResult {
    data class Success(val user: FirebaseUser?) : SignInResult()
    data class Error(val exception: Exception) : SignInResult()
    object None : SignInResult()
}