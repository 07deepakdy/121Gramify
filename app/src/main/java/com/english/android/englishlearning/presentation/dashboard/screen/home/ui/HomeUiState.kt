package com.english.android.englishlearning.presentation.dashboard.screen.home.ui

data class HomeUiState(
    val chipItems: List<String> = emptyList(),
    val selectedChips: Set<String> = emptySet(),
    val cardItems: List<HomeCardItem> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)

data class HomeCardItem(
    val title: String,
    val icon: Int
)


