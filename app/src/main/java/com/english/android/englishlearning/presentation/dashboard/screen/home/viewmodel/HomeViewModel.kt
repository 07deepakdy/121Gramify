package com.english.android.englishlearning.presentation.dashboard.screen.home.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.english.android.englishlearning.R
import com.english.android.englishlearning.presentation.dashboard.screen.home.ui.HomeCardItem
import com.english.android.englishlearning.presentation.dashboard.screen.home.ui.HomeUiState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        HomeUiState(
            chipItems = listOf(
                "Grammar",
                "Vocabulary",
                "Speaking",
                "Listening",
                "Writing"
            ),
            selectedChips = emptySet(),
            cardItems = listOf(
                HomeCardItem("Listening", R.drawable.daily_practice),
                HomeCardItem("Speaking", R.drawable.speak),
                HomeCardItem("Writing", R.drawable.book),
                HomeCardItem("Mock Exam", R.drawable.cal)
            )
        )
    )

    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()
    private val _navigationEvent = MutableSharedFlow<String>()
    val navigationEvent = _navigationEvent.asSharedFlow()

    /* ---------------- Events ---------------- */

    fun onChipClicked(chip: String) {
        _uiState.update { state ->
            val updatedSelection =
                if (state.selectedChips.contains(chip)) {
                    state.selectedChips - chip
                } else {
                    state.selectedChips + chip
                }

            state.copy(selectedChips = updatedSelection)
        }
    }

    fun onCardClicked(cardTitle: String) {
        Log.d("Home", "Card clicked: $cardTitle")
        viewModelScope.launch {
            _navigationEvent.emit(cardTitle)
        }
    }

}
