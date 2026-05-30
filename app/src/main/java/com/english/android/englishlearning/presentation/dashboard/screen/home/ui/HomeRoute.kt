package com.english.android.englishlearning.presentation.dashboard.screen.home.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.english.android.englishlearning.presentation.dashboard.screen.home.HomeScreen
import com.english.android.englishlearning.presentation.dashboard.screen.home.viewmodel.HomeViewModel
import com.english.android.englishlearning.presentation.dashboard.utils.DashboardDestination

@Composable
fun HomeRoute(
    navController: NavController,
    viewModel: HomeViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {

        viewModel.navigationEvent.collect { title ->
            when (title) {
                "Listening" -> navController.navigate("listening")
                "Speaking" -> {
                    navController.navigate(
                    DashboardDestination.SpeakingPlatform.route
                )}
                "Writing" -> navController.navigate("writing")
                "Mock Exam" -> navController.navigate("mock_exam")
            }
        }
    }

    HomeScreen()
}



