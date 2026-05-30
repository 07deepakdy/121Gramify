package com.english.android.englishlearning.presentation.signup.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.english.android.englishlearning.data.repository.AuthRepositoryImpl
import com.english.android.englishlearning.domain.usecase.SignupUseCase
import com.english.android.englishlearning.presentation.signup.SignupEvent
import com.english.android.englishlearning.presentation.signup.SignupUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

open class SignupViewModel(
    private val signupUseCase: SignupUseCase = SignupUseCase(AuthRepositoryImpl())
) : ViewModel() {

    private val _uiState = MutableStateFlow(SignupUiState())
    val uiState = _uiState.asStateFlow()

    fun onEvent(event: SignupEvent) {

        when (event) {
            is SignupEvent.NameChanged ->
                _uiState.value = _uiState.value.copy(name = event.value)

            is SignupEvent.EmailChanged ->
                _uiState.value = _uiState.value.copy(email = event.value)

            is SignupEvent.PasswordChanged ->
                _uiState.value = _uiState.value.copy(password = event.value)

            SignupEvent.Submit -> signup()
        }

    }

    private fun signup() {
        val current = _uiState.value

        viewModelScope.launch {
            _uiState.value = current.copy(loading = true)

            val result = signupUseCase(
                current.name,
                current.email,
                current.password
            )

            if (result.isSuccess) {
                _uiState.value = _uiState.value.copy(
                    loading = false,
                    signupSuccess = true,
                    message = "Verification email sent. Please check your inbox."
                )
            } else {
                _uiState.value = _uiState.value.copy(
                    loading = false,
                    errorMessage = result.exceptionOrNull()?.message
                )
            }
        }
    }


    /*  private fun signup() {
          val currentState = _uiState.value



          viewModelScope.launch {
              _uiState.value = currentState.copy(loading = true)

              val result = signupUseCase(currentState.name, currentState.email, currentState.password)

              if (result.isSuccess) {
                  _uiState.value = _uiState.value.copy(
                      loading = false,
                      signupSuccess = true
                  )
              } else {
                  _uiState.value = _uiState.value.copy(
                      loading = false,
                      errorMessage = result.exceptionOrNull()?.message
                  )
              }
          }
      }*/


}