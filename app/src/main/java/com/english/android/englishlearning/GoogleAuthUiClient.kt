package com.english.android.englishlearning

import android.content.Context
import androidx.credentials.*
import androidx.credentials.GetCredentialRequest
import androidx.credentials.GetCredentialResponse
import androidx.credentials.exceptions.GetCredentialException
import com.english.android.englishlearning.presentation.signup.SignInResult
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await


class GoogleAuthUiClient(private val context: Context) {

    private val credentialManager = CredentialManager.create(context)
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun signIn(
        activityContext: Context,
        nonce: String,
        scope: CoroutineScope,
        onResult: (SignInResult) -> Unit
    ) {
        val googleIdOption = buildGoogleIdOption(true, nonce)

        val request = GetCredentialRequest.Builder()
            .addCredentialOption(googleIdOption)
            .build()

        scope.launch(Dispatchers.IO) {
            try {
                val result = credentialManager.getCredential(
                    request = request,
                    context = activityContext
                )
                handleSignIn(result, onResult)
            } catch (e: GetCredentialException) {
                // Fallback: no previously signed-in accounts
                try {
                    val fallbackRequest = GetCredentialRequest.Builder()
                        .addCredentialOption(buildGoogleIdOption(false, nonce))
                        .build()

                    val fallbackResult = credentialManager.getCredential(
                        context = activityContext, //  context first
                        request = fallbackRequest  //  then request
                    )

                    handleSignIn(fallbackResult, onResult)

                } catch (e: Exception) {
                    onResult(SignInResult.Error(e))
                }

            } catch (e: Exception) {
                onResult(SignInResult.Error(e))
            }
        }
    }

    private fun buildGoogleIdOption(filterByAuthorizedAccounts: Boolean, nonce: String): GetGoogleIdOption {
        return GetGoogleIdOption.Builder()
            .setFilterByAuthorizedAccounts(filterByAuthorizedAccounts)
            .setServerClientId(context.getString(R.string.default_web_client_id)) // ✅ Must be Web client ID from Firebase
            .setAutoSelectEnabled(true)
            .setNonce(nonce)
            .build()
    }

    private suspend fun handleSignIn(
        result: GetCredentialResponse,
        onResult: (SignInResult) -> Unit
    ) {
        val credential = result.credential

        when (credential) {
            is CustomCredential -> {
                if (credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
                    try {
                        val googleIdTokenCredential = GoogleIdTokenCredential.createFrom(credential.data)
                        val idToken = googleIdTokenCredential.idToken
                        if (idToken.isNullOrEmpty()) {
                            onResult(SignInResult.Error(Exception("ID token is null")))
                        } else {
                            val firebaseCredential = GoogleAuthProvider.getCredential(idToken, null)
                            val authResult = auth.signInWithCredential(firebaseCredential).await()
                            onResult(SignInResult.Success(authResult.user))
                        }
                    } catch (e: GoogleIdTokenParsingException) {
                        onResult(SignInResult.Error(Exception("Invalid Google ID Token", e)))
                    }
                }
                else {
                    onResult(SignInResult.Error(Exception("Unsupported CustomCredential type")))
                }
            }
            else -> {
                onResult(SignInResult.Error(Exception("Unexpected credential type: ${credential::class.java.name}")))
            }
        }
    }

    fun signOut() {
        auth.signOut()
    }
    fun getSignedInUser(): FirebaseUser? {
        return auth.currentUser
    }
}
