package com.english.android.englishlearning.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.english.android.englishlearning.presentation.intro.IntroScreen
import com.english.android.englishlearning.presentation.dashboard.DashboardScreen
import com.english.android.englishlearning.presentation.login.LoginScreen
import com.english.android.englishlearning.presentation.signup.SignUpScreen
import com.english.android.englishlearning.presentation.login.LoginViewModel
import com.english.android.englishlearning.presentation.speaking.SpeakingPlatformScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    authViewModel: LoginViewModel
) {
    val isLoggedIn by authViewModel.isLoggedIn.collectAsState()
    val startDestination = remember(isLoggedIn) {
        if (isLoggedIn) {
            Screen.Dashboard.route
        }else{
            Screen.Intro.route
        }
    }


    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        // Intro screen
        composable(Screen.Intro.route) {
            IntroScreen(
                onNext = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.Intro.route) { inclusive = true }
                    }
                }
            )
        }


        // Login
        composable(Screen.Login.route) {
            LoginScreen(
                viewModel = authViewModel,
                onLoginSuccess = {
                    navController.navigate(Screen.Dashboard.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                },
                onEmailClick = {
                    navController.navigate(Screen.SignUp.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                },
                navController = navController
            )
        }

        // Signup
        composable(Screen.SignUp.route) {
            SignUpScreen(
                onSignUpSuccess = {
                    navController.navigate(Screen.Dashboard.route) {
                        popUpTo(Screen.SignUp.route) { inclusive = true }
                    }
                },
                navController = navController
            )
        }


        // Dashboard
        composable(Screen.Dashboard.route) {
            DashboardScreen()
        }

        composable(Screen.SpeakingPlatform.route) {
            SpeakingPlatformScreen(
                onBack = { navController.popBackStack() }
            )
        }




    }

    // ✅ Handle login state change HERE
    LaunchedEffect(isLoggedIn) {
        if (isLoggedIn) {
            navController.navigate(Screen.Dashboard.route) {
                popUpTo(Screen.Intro.route) { inclusive = true }
                launchSingleTop = true
            }
        }
    }
}