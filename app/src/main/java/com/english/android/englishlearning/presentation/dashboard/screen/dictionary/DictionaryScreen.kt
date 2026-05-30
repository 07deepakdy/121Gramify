package com.english.android.englishlearning.presentation.dashboard.screen.dictionary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.english.android.englishlearning.presentation.dashboard.screen.dictionary.ui.DictionarySearchBar
import com.english.android.englishlearning.presentation.dashboard.screen.dictionary.ui.DictionaryWordCard
import com.english.android.englishlearning.presentation.dashboard.screen.dictionary.ui.RecentSearchSection
import com.english.android.englishlearning.presentation.dashboard.screen.dictionary.ui.TrendingSection
import com.english.android.englishlearning.ui.theme.AppTheme

@Composable
fun DictionaryScreen(){
    var searchQuery by remember { mutableStateOf("") }
    val recentWords = remember { mutableStateListOf("Ephemeral", "Eloquence", "Serendipity") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F8F8))
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // Search Bar
            item {
                DictionarySearchBar(
                    query = searchQuery,
                    onQueryChange = { searchQuery = it },
                    onSearch = { word ->
                        if (word.isNotBlank()) {
                            // Add to top and maintain uniqueness
                            recentWords.remove(word)
                            recentWords.add(0, word)
                            if (recentWords.size > 5) {
                                recentWords.removeAt(recentWords.size - 1)
                            }
                            searchQuery = "" // Clear search after adding to history
                        }
                    }
                )
            }

            // Word of the Day Card
            item {
                DictionaryWordCard()
            }

            // Recent Section
            item {
                RecentSearchSection(recentWords = recentWords)
            }

            // Trending Section
            item {
                TrendingSection()
            }
            
            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Preview(
    name = "Dictionary Screen",
    showBackground = true,
    device = Devices.PIXEL_7
)
@Composable
fun DictionaryScreenPreview() {
    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFF8F8F8)
        ) {
            DictionaryScreen()
        }
    }
}
