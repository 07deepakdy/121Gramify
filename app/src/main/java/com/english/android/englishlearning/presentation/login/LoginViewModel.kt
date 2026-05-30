package com.english.android.englishlearning.presentation.login

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.english.android.englishlearning.GoogleAuthUiClient
import com.english.android.englishlearning.presentation.signup.SignInResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

open class LoginViewModel(context: Context) : ViewModel() {

    private val googleAuthUiClient = GoogleAuthUiClient(context)

    private val _signInResult = MutableStateFlow<SignInResult?>(SignInResult.None)
    open val signInResult: StateFlow<SignInResult?> = _signInResult

    private val _userName = MutableStateFlow<String?>(null)
    val userName: StateFlow<String?> = _userName


    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn: StateFlow<Boolean> = _isLoggedIn

     init {
         checkExistingLogin()
     }

    private fun checkExistingLogin() {
        val user = googleAuthUiClient.getSignedInUser()
        if (user != null) {
            _userName.value = user.displayName
            _isLoggedIn.value = true
        }
    }


    fun launchGoogleSignIn(activityContext: Context) {
        val nonce = generateRandomNonce()
        googleAuthUiClient.signIn(
            activityContext = activityContext,
            nonce = nonce,
            scope = viewModelScope
        ) { result ->

            if (result is SignInResult.Success) {
                _userName.value = result.user?.displayName
            }
            _signInResult.value = result
        }
    }

    fun signOut() {
        googleAuthUiClient.signOut()
        _signInResult.value = SignInResult.None
    }

    private fun generateRandomNonce(length: Int = 32): String {
        val charset = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz-._"
        return (1..length).map { charset.random() }.joinToString("")
    }

    fun clearSignInResult() {
        _signInResult.value = SignInResult.None
    }

}