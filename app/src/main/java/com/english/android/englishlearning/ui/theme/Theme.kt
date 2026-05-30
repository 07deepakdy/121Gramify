package com.english.android.englishlearning.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.english.android.englishlearning.backgroundDark
import com.english.android.englishlearning.backgroundDarkHighContrast
import com.english.android.englishlearning.backgroundDarkMediumContrast
import com.english.android.englishlearning.backgroundLight
import com.english.android.englishlearning.backgroundLightHighContrast
import com.english.android.englishlearning.backgroundLightMediumContrast
import com.english.android.englishlearning.errorContainerDark
import com.english.android.englishlearning.errorContainerDarkHighContrast
import com.english.android.englishlearning.errorContainerDarkMediumContrast
import com.english.android.englishlearning.errorContainerLight
import com.english.android.englishlearning.errorContainerLightHighContrast
import com.english.android.englishlearning.errorContainerLightMediumContrast
import com.english.android.englishlearning.errorDark
import com.english.android.englishlearning.errorDarkHighContrast
import com.english.android.englishlearning.errorDarkMediumContrast
import com.english.android.englishlearning.errorLight
import com.english.android.englishlearning.errorLightHighContrast
import com.english.android.englishlearning.errorLightMediumContrast
import com.english.android.englishlearning.inverseOnSurfaceDark
import com.english.android.englishlearning.inverseOnSurfaceDarkHighContrast
import com.english.android.englishlearning.inverseOnSurfaceDarkMediumContrast
import com.english.android.englishlearning.inverseOnSurfaceLight
import com.english.android.englishlearning.inverseOnSurfaceLightHighContrast
import com.english.android.englishlearning.inverseOnSurfaceLightMediumContrast
import com.english.android.englishlearning.inversePrimaryDark
import com.english.android.englishlearning.inversePrimaryDarkHighContrast
import com.english.android.englishlearning.inversePrimaryDarkMediumContrast
import com.english.android.englishlearning.inversePrimaryLight
import com.english.android.englishlearning.inversePrimaryLightHighContrast
import com.english.android.englishlearning.inversePrimaryLightMediumContrast
import com.english.android.englishlearning.inverseSurfaceDark
import com.english.android.englishlearning.inverseSurfaceDarkHighContrast
import com.english.android.englishlearning.inverseSurfaceDarkMediumContrast
import com.english.android.englishlearning.inverseSurfaceLight
import com.english.android.englishlearning.inverseSurfaceLightHighContrast
import com.english.android.englishlearning.inverseSurfaceLightMediumContrast
import com.english.android.englishlearning.onBackgroundDark
import com.english.android.englishlearning.onBackgroundDarkHighContrast
import com.english.android.englishlearning.onBackgroundDarkMediumContrast
import com.english.android.englishlearning.onBackgroundLight
import com.english.android.englishlearning.onBackgroundLightHighContrast
import com.english.android.englishlearning.onBackgroundLightMediumContrast
import com.english.android.englishlearning.onErrorContainerDark
import com.english.android.englishlearning.onErrorContainerDarkHighContrast
import com.english.android.englishlearning.onErrorContainerDarkMediumContrast
import com.english.android.englishlearning.onErrorContainerLight
import com.english.android.englishlearning.onErrorContainerLightHighContrast
import com.english.android.englishlearning.onErrorContainerLightMediumContrast
import com.english.android.englishlearning.onErrorDark
import com.english.android.englishlearning.onErrorDarkHighContrast
import com.english.android.englishlearning.onErrorDarkMediumContrast
import com.english.android.englishlearning.onErrorLight
import com.english.android.englishlearning.onErrorLightHighContrast
import com.english.android.englishlearning.onErrorLightMediumContrast
import com.english.android.englishlearning.onPrimaryContainerDark
import com.english.android.englishlearning.onPrimaryContainerDarkHighContrast
import com.english.android.englishlearning.onPrimaryContainerDarkMediumContrast
import com.english.android.englishlearning.onPrimaryContainerLight
import com.english.android.englishlearning.onPrimaryContainerLightHighContrast
import com.english.android.englishlearning.onPrimaryContainerLightMediumContrast
import com.english.android.englishlearning.onPrimaryDark
import com.english.android.englishlearning.onPrimaryDarkHighContrast
import com.english.android.englishlearning.onPrimaryDarkMediumContrast
import com.english.android.englishlearning.onPrimaryLight
import com.english.android.englishlearning.onPrimaryLightHighContrast
import com.english.android.englishlearning.onPrimaryLightMediumContrast
import com.english.android.englishlearning.onSecondaryContainerDark
import com.english.android.englishlearning.onSecondaryContainerDarkHighContrast
import com.english.android.englishlearning.onSecondaryContainerDarkMediumContrast
import com.english.android.englishlearning.onSecondaryContainerLight
import com.english.android.englishlearning.onSecondaryContainerLightHighContrast
import com.english.android.englishlearning.onSecondaryContainerLightMediumContrast
import com.english.android.englishlearning.onSecondaryDark
import com.english.android.englishlearning.onSecondaryDarkHighContrast
import com.english.android.englishlearning.onSecondaryDarkMediumContrast
import com.english.android.englishlearning.onSecondaryLight
import com.english.android.englishlearning.onSecondaryLightHighContrast
import com.english.android.englishlearning.onSecondaryLightMediumContrast
import com.english.android.englishlearning.onSurfaceDark
import com.english.android.englishlearning.onSurfaceDarkHighContrast
import com.english.android.englishlearning.onSurfaceDarkMediumContrast
import com.english.android.englishlearning.onSurfaceLight
import com.english.android.englishlearning.onSurfaceLightHighContrast
import com.english.android.englishlearning.onSurfaceLightMediumContrast
import com.english.android.englishlearning.onSurfaceVariantDark
import com.english.android.englishlearning.onSurfaceVariantDarkHighContrast
import com.english.android.englishlearning.onSurfaceVariantDarkMediumContrast
import com.english.android.englishlearning.onSurfaceVariantLight
import com.english.android.englishlearning.onSurfaceVariantLightHighContrast
import com.english.android.englishlearning.onSurfaceVariantLightMediumContrast
import com.english.android.englishlearning.onTertiaryContainerDark
import com.english.android.englishlearning.onTertiaryContainerDarkHighContrast
import com.english.android.englishlearning.onTertiaryContainerDarkMediumContrast
import com.english.android.englishlearning.onTertiaryContainerLight
import com.english.android.englishlearning.onTertiaryContainerLightHighContrast
import com.english.android.englishlearning.onTertiaryContainerLightMediumContrast
import com.english.android.englishlearning.onTertiaryDark
import com.english.android.englishlearning.onTertiaryDarkHighContrast
import com.english.android.englishlearning.onTertiaryDarkMediumContrast
import com.english.android.englishlearning.onTertiaryLight
import com.english.android.englishlearning.onTertiaryLightHighContrast
import com.english.android.englishlearning.onTertiaryLightMediumContrast
import com.english.android.englishlearning.outlineDark
import com.english.android.englishlearning.outlineDarkHighContrast
import com.english.android.englishlearning.outlineDarkMediumContrast
import com.english.android.englishlearning.outlineLight
import com.english.android.englishlearning.outlineLightHighContrast
import com.english.android.englishlearning.outlineLightMediumContrast
import com.english.android.englishlearning.outlineVariantDark
import com.english.android.englishlearning.outlineVariantDarkHighContrast
import com.english.android.englishlearning.outlineVariantDarkMediumContrast
import com.english.android.englishlearning.outlineVariantLight
import com.english.android.englishlearning.outlineVariantLightHighContrast
import com.english.android.englishlearning.outlineVariantLightMediumContrast
import com.english.android.englishlearning.primaryContainerDark
import com.english.android.englishlearning.primaryContainerDarkHighContrast
import com.english.android.englishlearning.primaryContainerDarkMediumContrast
import com.english.android.englishlearning.primaryContainerLight
import com.english.android.englishlearning.primaryContainerLightHighContrast
import com.english.android.englishlearning.primaryContainerLightMediumContrast
import com.english.android.englishlearning.primaryDark
import com.english.android.englishlearning.primaryDarkHighContrast
import com.english.android.englishlearning.primaryDarkMediumContrast
import com.english.android.englishlearning.primaryLight
import com.english.android.englishlearning.primaryLightHighContrast
import com.english.android.englishlearning.primaryLightMediumContrast
import com.english.android.englishlearning.scrimDark
import com.english.android.englishlearning.scrimDarkHighContrast
import com.english.android.englishlearning.scrimDarkMediumContrast
import com.english.android.englishlearning.scrimLight
import com.english.android.englishlearning.scrimLightHighContrast
import com.english.android.englishlearning.scrimLightMediumContrast
import com.english.android.englishlearning.secondaryContainerDark
import com.english.android.englishlearning.secondaryContainerDarkHighContrast
import com.english.android.englishlearning.secondaryContainerDarkMediumContrast
import com.english.android.englishlearning.secondaryContainerLight
import com.english.android.englishlearning.secondaryContainerLightHighContrast
import com.english.android.englishlearning.secondaryContainerLightMediumContrast
import com.english.android.englishlearning.secondaryDark
import com.english.android.englishlearning.secondaryDarkHighContrast
import com.english.android.englishlearning.secondaryDarkMediumContrast
import com.english.android.englishlearning.secondaryLight
import com.english.android.englishlearning.secondaryLightHighContrast
import com.english.android.englishlearning.secondaryLightMediumContrast
import com.english.android.englishlearning.surfaceBrightDark
import com.english.android.englishlearning.surfaceBrightDarkHighContrast
import com.english.android.englishlearning.surfaceBrightDarkMediumContrast
import com.english.android.englishlearning.surfaceBrightLight
import com.english.android.englishlearning.surfaceBrightLightHighContrast
import com.english.android.englishlearning.surfaceBrightLightMediumContrast
import com.english.android.englishlearning.surfaceContainerDark
import com.english.android.englishlearning.surfaceContainerDarkHighContrast
import com.english.android.englishlearning.surfaceContainerDarkMediumContrast
import com.english.android.englishlearning.surfaceContainerHighDark
import com.english.android.englishlearning.surfaceContainerHighDarkHighContrast
import com.english.android.englishlearning.surfaceContainerHighDarkMediumContrast
import com.english.android.englishlearning.surfaceContainerHighLight
import com.english.android.englishlearning.surfaceContainerHighLightHighContrast
import com.english.android.englishlearning.surfaceContainerHighLightMediumContrast
import com.english.android.englishlearning.surfaceContainerHighestDark
import com.english.android.englishlearning.surfaceContainerHighestDarkHighContrast
import com.english.android.englishlearning.surfaceContainerHighestDarkMediumContrast
import com.english.android.englishlearning.surfaceContainerHighestLight
import com.english.android.englishlearning.surfaceContainerHighestLightHighContrast
import com.english.android.englishlearning.surfaceContainerHighestLightMediumContrast
import com.english.android.englishlearning.surfaceContainerLight
import com.english.android.englishlearning.surfaceContainerLightHighContrast
import com.english.android.englishlearning.surfaceContainerLightMediumContrast
import com.english.android.englishlearning.surfaceContainerLowDark
import com.english.android.englishlearning.surfaceContainerLowDarkHighContrast
import com.english.android.englishlearning.surfaceContainerLowDarkMediumContrast
import com.english.android.englishlearning.surfaceContainerLowLight
import com.english.android.englishlearning.surfaceContainerLowLightHighContrast
import com.english.android.englishlearning.surfaceContainerLowLightMediumContrast
import com.english.android.englishlearning.surfaceContainerLowestDark
import com.english.android.englishlearning.surfaceContainerLowestDarkHighContrast
import com.english.android.englishlearning.surfaceContainerLowestDarkMediumContrast
import com.english.android.englishlearning.surfaceContainerLowestLight
import com.english.android.englishlearning.surfaceContainerLowestLightHighContrast
import com.english.android.englishlearning.surfaceContainerLowestLightMediumContrast
import com.english.android.englishlearning.surfaceDark
import com.english.android.englishlearning.surfaceDarkHighContrast
import com.english.android.englishlearning.surfaceDarkMediumContrast
import com.english.android.englishlearning.surfaceDimDark
import com.english.android.englishlearning.surfaceDimDarkHighContrast
import com.english.android.englishlearning.surfaceDimDarkMediumContrast
import com.english.android.englishlearning.surfaceDimLight
import com.english.android.englishlearning.surfaceDimLightHighContrast
import com.english.android.englishlearning.surfaceDimLightMediumContrast
import com.english.android.englishlearning.surfaceLight
import com.english.android.englishlearning.surfaceLightHighContrast
import com.english.android.englishlearning.surfaceLightMediumContrast
import com.english.android.englishlearning.surfaceVariantDark
import com.english.android.englishlearning.surfaceVariantDarkHighContrast
import com.english.android.englishlearning.surfaceVariantDarkMediumContrast
import com.english.android.englishlearning.surfaceVariantLight
import com.english.android.englishlearning.surfaceVariantLightHighContrast
import com.english.android.englishlearning.surfaceVariantLightMediumContrast
import com.english.android.englishlearning.tertiaryContainerDark
import com.english.android.englishlearning.tertiaryContainerDarkHighContrast
import com.english.android.englishlearning.tertiaryContainerDarkMediumContrast
import com.english.android.englishlearning.tertiaryContainerLight
import com.english.android.englishlearning.tertiaryContainerLightHighContrast
import com.english.android.englishlearning.tertiaryContainerLightMediumContrast
import com.english.android.englishlearning.tertiaryDark
import com.english.android.englishlearning.tertiaryDarkHighContrast
import com.english.android.englishlearning.tertiaryDarkMediumContrast
import com.english.android.englishlearning.tertiaryLight
import com.english.android.englishlearning.tertiaryLightHighContrast
import com.english.android.englishlearning.tertiaryLightMediumContrast


private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)

private val mediumContrastLightColorScheme = lightColorScheme(
    primary = primaryLightMediumContrast,
    onPrimary = onPrimaryLightMediumContrast,
    primaryContainer = primaryContainerLightMediumContrast,
    onPrimaryContainer = onPrimaryContainerLightMediumContrast,
    secondary = secondaryLightMediumContrast,
    onSecondary = onSecondaryLightMediumContrast,
    secondaryContainer = secondaryContainerLightMediumContrast,
    onSecondaryContainer = onSecondaryContainerLightMediumContrast,
    tertiary = tertiaryLightMediumContrast,
    onTertiary = onTertiaryLightMediumContrast,
    tertiaryContainer = tertiaryContainerLightMediumContrast,
    onTertiaryContainer = onTertiaryContainerLightMediumContrast,
    error = errorLightMediumContrast,
    onError = onErrorLightMediumContrast,
    errorContainer = errorContainerLightMediumContrast,
    onErrorContainer = onErrorContainerLightMediumContrast,
    background = backgroundLightMediumContrast,
    onBackground = onBackgroundLightMediumContrast,
    surface = surfaceLightMediumContrast,
    onSurface = onSurfaceLightMediumContrast,
    surfaceVariant = surfaceVariantLightMediumContrast,
    onSurfaceVariant = onSurfaceVariantLightMediumContrast,
    outline = outlineLightMediumContrast,
    outlineVariant = outlineVariantLightMediumContrast,
    scrim = scrimLightMediumContrast,
    inverseSurface = inverseSurfaceLightMediumContrast,
    inverseOnSurface = inverseOnSurfaceLightMediumContrast,
    inversePrimary = inversePrimaryLightMediumContrast,
    surfaceDim = surfaceDimLightMediumContrast,
    surfaceBright = surfaceBrightLightMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestLightMediumContrast,
    surfaceContainerLow = surfaceContainerLowLightMediumContrast,
    surfaceContainer = surfaceContainerLightMediumContrast,
    surfaceContainerHigh = surfaceContainerHighLightMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestLightMediumContrast,
)

private val highContrastLightColorScheme = lightColorScheme(
    primary = primaryLightHighContrast,
    onPrimary = onPrimaryLightHighContrast,
    primaryContainer = primaryContainerLightHighContrast,
    onPrimaryContainer = onPrimaryContainerLightHighContrast,
    secondary = secondaryLightHighContrast,
    onSecondary = onSecondaryLightHighContrast,
    secondaryContainer = secondaryContainerLightHighContrast,
    onSecondaryContainer = onSecondaryContainerLightHighContrast,
    tertiary = tertiaryLightHighContrast,
    onTertiary = onTertiaryLightHighContrast,
    tertiaryContainer = tertiaryContainerLightHighContrast,
    onTertiaryContainer = onTertiaryContainerLightHighContrast,
    error = errorLightHighContrast,
    onError = onErrorLightHighContrast,
    errorContainer = errorContainerLightHighContrast,
    onErrorContainer = onErrorContainerLightHighContrast,
    background = backgroundLightHighContrast,
    onBackground = onBackgroundLightHighContrast,
    surface = surfaceLightHighContrast,
    onSurface = onSurfaceLightHighContrast,
    surfaceVariant = surfaceVariantLightHighContrast,
    onSurfaceVariant = onSurfaceVariantLightHighContrast,
    outline = outlineLightHighContrast,
    outlineVariant = outlineVariantLightHighContrast,
    scrim = scrimLightHighContrast,
    inverseSurface = inverseSurfaceLightHighContrast,
    inverseOnSurface = inverseOnSurfaceLightHighContrast,
    inversePrimary = inversePrimaryLightHighContrast,
    surfaceDim = surfaceDimLightHighContrast,
    surfaceBright = surfaceBrightLightHighContrast,
    surfaceContainerLowest = surfaceContainerLowestLightHighContrast,
    surfaceContainerLow = surfaceContainerLowLightHighContrast,
    surfaceContainer = surfaceContainerLightHighContrast,
    surfaceContainerHigh = surfaceContainerHighLightHighContrast,
    surfaceContainerHighest = surfaceContainerHighestLightHighContrast,
)

private val mediumContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkMediumContrast,
    onPrimary = onPrimaryDarkMediumContrast,
    primaryContainer = primaryContainerDarkMediumContrast,
    onPrimaryContainer = onPrimaryContainerDarkMediumContrast,
    secondary = secondaryDarkMediumContrast,
    onSecondary = onSecondaryDarkMediumContrast,
    secondaryContainer = secondaryContainerDarkMediumContrast,
    onSecondaryContainer = onSecondaryContainerDarkMediumContrast,
    tertiary = tertiaryDarkMediumContrast,
    onTertiary = onTertiaryDarkMediumContrast,
    tertiaryContainer = tertiaryContainerDarkMediumContrast,
    onTertiaryContainer = onTertiaryContainerDarkMediumContrast,
    error = errorDarkMediumContrast,
    onError = onErrorDarkMediumContrast,
    errorContainer = errorContainerDarkMediumContrast,
    onErrorContainer = onErrorContainerDarkMediumContrast,
    background = backgroundDarkMediumContrast,
    onBackground = onBackgroundDarkMediumContrast,
    surface = surfaceDarkMediumContrast,
    onSurface = onSurfaceDarkMediumContrast,
    surfaceVariant = surfaceVariantDarkMediumContrast,
    onSurfaceVariant = onSurfaceVariantDarkMediumContrast,
    outline = outlineDarkMediumContrast,
    outlineVariant = outlineVariantDarkMediumContrast,
    scrim = scrimDarkMediumContrast,
    inverseSurface = inverseSurfaceDarkMediumContrast,
    inverseOnSurface = inverseOnSurfaceDarkMediumContrast,
    inversePrimary = inversePrimaryDarkMediumContrast,
    surfaceDim = surfaceDimDarkMediumContrast,
    surfaceBright = surfaceBrightDarkMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkMediumContrast,
    surfaceContainerLow = surfaceContainerLowDarkMediumContrast,
    surfaceContainer = surfaceContainerDarkMediumContrast,
    surfaceContainerHigh = surfaceContainerHighDarkMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkMediumContrast,
)

private val highContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkHighContrast,
    onPrimary = onPrimaryDarkHighContrast,
    primaryContainer = primaryContainerDarkHighContrast,
    onPrimaryContainer = onPrimaryContainerDarkHighContrast,
    secondary = secondaryDarkHighContrast,
    onSecondary = onSecondaryDarkHighContrast,
    secondaryContainer = secondaryContainerDarkHighContrast,
    onSecondaryContainer = onSecondaryContainerDarkHighContrast,
    tertiary = tertiaryDarkHighContrast,
    onTertiary = onTertiaryDarkHighContrast,
    tertiaryContainer = tertiaryContainerDarkHighContrast,
    onTertiaryContainer = onTertiaryContainerDarkHighContrast,
    error = errorDarkHighContrast,
    onError = onErrorDarkHighContrast,
    errorContainer = errorContainerDarkHighContrast,
    onErrorContainer = onErrorContainerDarkHighContrast,
    background = backgroundDarkHighContrast,
    onBackground = onBackgroundDarkHighContrast,
    surface = surfaceDarkHighContrast,
    onSurface = onSurfaceDarkHighContrast,
    surfaceVariant = surfaceVariantDarkHighContrast,
    onSurfaceVariant = onSurfaceVariantDarkHighContrast,
    outline = outlineDarkHighContrast,
    outlineVariant = outlineVariantDarkHighContrast,
    scrim = scrimDarkHighContrast,
    inverseSurface = inverseSurfaceDarkHighContrast,
    inverseOnSurface = inverseOnSurfaceDarkHighContrast,
    inversePrimary = inversePrimaryDarkHighContrast,
    surfaceDim = surfaceDimDarkHighContrast,
    surfaceBright = surfaceBrightDarkHighContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkHighContrast,
    surfaceContainerLow = surfaceContainerLowDarkHighContrast,
    surfaceContainer = surfaceContainerDarkHighContrast,
    surfaceContainerHigh = surfaceContainerHighDarkHighContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkHighContrast,
)

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable() () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> darkScheme
        else -> lightScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )
}
