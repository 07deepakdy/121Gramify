package com.english.android.englishlearning.presentation.dashboard.screen.grammar.ui

import androidx.compose.ui.graphics.Color

enum class RuleStatus {
    MASTERED, IN_PROGRESS, NOT_STARTED
}

data class GrammarRule(
    val id: Int,
    val title: String,
    val description: String,
    val status: RuleStatus,
    val progress: Float = 0f,
    val duration: String? = null,
    val completionDate: String? = null,
    val accentColor: Color = Color.Gray
)
