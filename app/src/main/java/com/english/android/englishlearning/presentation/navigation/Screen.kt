package com.english.android.englishlearning.presentation.navigation

sealed class Screen(val route: String) {
    object Intro : Screen("intro_screen")
    object Login : Screen("login_screen")
    object SignUp : Screen("signup_screen")
    object Dashboard : Screen("dashboard_screen")
    object SpeakingPlatform : Screen("speaking_platform")
}