package com.english.android.englishlearning.domain.repository

interface AuthRepository {
    suspend fun signup(name:String,email:String,password: String): Result<Unit>
}