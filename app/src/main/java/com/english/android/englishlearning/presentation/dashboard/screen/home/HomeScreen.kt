package com.english.android.englishlearning.presentation.dashboard.screen.home



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.english.android.englishlearning.presentation.dashboard.screen.home.ui.FeatureGrid
import com.english.android.englishlearning.presentation.dashboard.screen.home.ui.GoalCard
import com.english.android.englishlearning.presentation.dashboard.screen.home.ui.HeaderSection
import com.english.android.englishlearning.presentation.dashboard.screen.home.ui.PremiumBanner
import com.english.android.englishlearning.presentation.dashboard.screen.home.ui.WordOfDayCard


@Composable
fun HomeScreen() {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F8F8)),
        contentPadding = PaddingValues(
            start = 16.dp,
            end = 16.dp,
            top = 16.dp,
            bottom = 24.dp
        ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        item {
            HeaderSection()
        }

        item {
            WordOfDayCard()
        }

        item {
            FeatureGrid()
        }

        item {
            GoalCard()
        }

        item {
            PremiumBanner()
        }
    }
}