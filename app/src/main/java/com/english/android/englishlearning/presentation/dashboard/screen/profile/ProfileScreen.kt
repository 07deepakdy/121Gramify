package com.english.android.englishlearning.presentation.dashboard.screen.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.english.android.englishlearning.presentation.dashboard.screen.profile.ui.AchievementsSection
import com.english.android.englishlearning.presentation.dashboard.screen.profile.ui.ProfileHeader
import com.english.android.englishlearning.presentation.dashboard.screen.profile.ui.SettingsSection
import com.english.android.englishlearning.presentation.dashboard.screen.profile.ui.StatsSection
import com.english.android.englishlearning.ui.theme.AppTheme

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F8F8))
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // Header
            item {
                ProfileHeader()
            }

            // Stats
            item {
                StatsSection()
            }

            // Achievements
            item {
                AchievementsSection()
            }

            // Settings
            item {
                SettingsSection()
            }

            // Sign Out
            item {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextButton(onClick = { }) {
                        Text(
                            text = "Sign Out",
                            color = Color.Red,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                }
            }
        }
    }
}

@Preview(
    name = "Profile Screen",
    showBackground = true,
    device = Devices.PIXEL_7
)
@Composable
fun ProfileScreenPreview() {
    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFF8F8F8)
        ) {
            ProfileScreen()
        }
    }
}
