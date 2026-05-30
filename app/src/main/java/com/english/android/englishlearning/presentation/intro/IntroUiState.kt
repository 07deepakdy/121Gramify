package com.english.android.englishlearning.presentation.intro

import com.english.android.englishlearning.domain.model.OnboardingPage


data class IntroUiState(
    val currentPage: Int = 0,
    val pages: List<OnboardingPage> = emptyList()
)
