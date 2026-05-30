package com.english.android.englishlearning.presentation.intro

import androidx.lifecycle.ViewModel
import com.english.android.englishlearning.R
import com.english.android.englishlearning.domain.model.OnboardingPage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class IntroViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(IntroUiState(pages = getPages()))
    val uiState: StateFlow<IntroUiState> = _uiState

    private fun getPages(): List<OnboardingPage> {
        return listOf(
            OnboardingPage(R.raw.reading_boy_animation, "Learn the Smart Way", "Unlock the secrets of English grammar with our expertly crafted 121 rules. Simple, powerful, and exam-ready explanations to level up your prep!."),
            OnboardingPage(R.raw.learning_animation, "Practice with Confidence", "Drill through hand-picked exercises and real-world grammar questions designed to mirror SSC, Bank, and Govt exam patterns. Practice that sticks!"),
            OnboardingPage(R.raw.quiz_animation, "Test Like a Pro", "Simulate the real exam environment with timed mock tests, instant scoring, and smart analytics. Know your strengths, fix your weak spots!")
        )
    }
}
