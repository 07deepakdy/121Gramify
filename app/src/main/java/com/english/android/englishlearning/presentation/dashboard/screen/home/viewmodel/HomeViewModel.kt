package com.english.android.englishlearning.presentation.dashboard.screen.home.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.english.android.englishlearning.R
import com.english.android.englishlearning.data.local.WordAssetDataSource
import com.english.android.englishlearning.data.remote.api.RetrofitClient
import com.english.android.englishlearning.data.repository.DictionaryRepositoryImpl
import com.english.android.englishlearning.domain.usecase.wordoftheday.GetWordOfDayUseCase
import com.english.android.englishlearning.presentation.dashboard.screen.home.ui.HomeCardItem
import com.english.android.englishlearning.presentation.dashboard.screen.home.ui.HomeUiState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel( private val getWordOfDayUseCase: GetWordOfDayUseCase) : ViewModel() {

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

    init {
        getWordOfDay()
    }

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

    private fun getWordOfDay() {

        viewModelScope.launch {

            _uiState.update {
                it.copy(
                    isLoading = true,
                    errorMessage = null
                )
            }

            runCatching {
                getWordOfDayUseCase()
            }.onSuccess { word ->

                _uiState.update {
                    it.copy(
                        wordOfDay = word,
                        isLoading = false
                    )
                }

            }.onFailure { throwable ->

                Log.e(
                    "HomeViewModel",
                    "Failed to load word of the day",
                    throwable
                )

                _uiState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = throwable.message
                            ?: "Something went wrong"
                    )
                }
            }
        }
    }

}
