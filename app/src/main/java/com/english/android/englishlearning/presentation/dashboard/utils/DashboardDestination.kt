package com.english.android.englishlearning.presentation.dashboard.utils

import androidx.annotation.DrawableRes
import com.english.android.englishlearning.R

sealed class DashboardDestination(
    val route: String,
    val label: String,
    @DrawableRes val iconRes: Int
) {

    object Home : DashboardDestination(
        route = "home",
        label = "Home",
        iconRes = R.drawable.home_24px
    )

    object Grammar : DashboardDestination(
        route = "grammar",
        label = "Grammar",
        iconRes = R.drawable.article_24px
    )

    object Dictionary : DashboardDestination(
        route = "dictionary",
        label = "Dictionary",
        iconRes = R.drawable.book
    )

    object Profile : DashboardDestination(
        route = "profile",
        label = "Profile",
        iconRes = R.drawable.account_circle_24px
    )

    object SpeakingPlatform : DashboardDestination(
        route = "speaking_platform",
        label = "Speaking",
        iconRes = R.drawable.account_circle_24px
    )

    companion object {
        val items = listOf(Home, Grammar, Dictionary, Profile)
    }
}
