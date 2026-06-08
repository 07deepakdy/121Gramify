package com.english.android.englishlearning.presentation.dashboard.screen.home.ui

import com.english.android.englishlearning.domain.model.DictionaryWord

data class HomeUiState(
    val chipItems: List<String> = emptyList(),
    val selectedChips: Set<String> = emptySet(),
    val cardItems: List<HomeCardItem> = emptyList(),
    val wordOfDay: DictionaryWord? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)

data class HomeCardItem(
    val title: String,
    val icon: Int
)


