package com.ml.fetchapplication.ui.theme

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
import com.ml.fetchapplication.backgroundDark
import com.ml.fetchapplication.backgroundDarkHighContrast
import com.ml.fetchapplication.backgroundDarkMediumContrast
import com.ml.fetchapplication.backgroundLight
import com.ml.fetchapplication.backgroundLightHighContrast
import com.ml.fetchapplication.backgroundLightMediumContrast
import com.ml.fetchapplication.errorContainerDark
import com.ml.fetchapplication.errorContainerDarkHighContrast
import com.ml.fetchapplication.errorContainerDarkMediumContrast
import com.ml.fetchapplication.errorContainerLight
import com.ml.fetchapplication.errorContainerLightHighContrast
import com.ml.fetchapplication.errorContainerLightMediumContrast
import com.ml.fetchapplication.errorDark
import com.ml.fetchapplication.errorDarkHighContrast
import com.ml.fetchapplication.errorDarkMediumContrast
import com.ml.fetchapplication.errorLight
import com.ml.fetchapplication.errorLightHighContrast
import com.ml.fetchapplication.errorLightMediumContrast
import com.ml.fetchapplication.inverseOnSurfaceDark
import com.ml.fetchapplication.inverseOnSurfaceDarkHighContrast
import com.ml.fetchapplication.inverseOnSurfaceDarkMediumContrast
import com.ml.fetchapplication.inverseOnSurfaceLight
import com.ml.fetchapplication.inverseOnSurfaceLightHighContrast
import com.ml.fetchapplication.inverseOnSurfaceLightMediumContrast
import com.ml.fetchapplication.inversePrimaryDark
import com.ml.fetchapplication.inversePrimaryDarkHighContrast
import com.ml.fetchapplication.inversePrimaryDarkMediumContrast
import com.ml.fetchapplication.inversePrimaryLight
import com.ml.fetchapplication.inversePrimaryLightHighContrast
import com.ml.fetchapplication.inversePrimaryLightMediumContrast
import com.ml.fetchapplication.inverseSurfaceDark
import com.ml.fetchapplication.inverseSurfaceDarkHighContrast
import com.ml.fetchapplication.inverseSurfaceDarkMediumContrast
import com.ml.fetchapplication.inverseSurfaceLight
import com.ml.fetchapplication.inverseSurfaceLightHighContrast
import com.ml.fetchapplication.inverseSurfaceLightMediumContrast
import com.ml.fetchapplication.onBackgroundDark
import com.ml.fetchapplication.onBackgroundDarkHighContrast
import com.ml.fetchapplication.onBackgroundDarkMediumContrast
import com.ml.fetchapplication.onBackgroundLight
import com.ml.fetchapplication.onBackgroundLightHighContrast
import com.ml.fetchapplication.onBackgroundLightMediumContrast
import com.ml.fetchapplication.onErrorContainerDark
import com.ml.fetchapplication.onErrorContainerDarkHighContrast
import com.ml.fetchapplication.onErrorContainerDarkMediumContrast
import com.ml.fetchapplication.onErrorContainerLight
import com.ml.fetchapplication.onErrorContainerLightHighContrast
import com.ml.fetchapplication.onErrorContainerLightMediumContrast
import com.ml.fetchapplication.onErrorDark
import com.ml.fetchapplication.onErrorDarkHighContrast
import com.ml.fetchapplication.onErrorDarkMediumContrast
import com.ml.fetchapplication.onErrorLight
import com.ml.fetchapplication.onErrorLightHighContrast
import com.ml.fetchapplication.onErrorLightMediumContrast
import com.ml.fetchapplication.onPrimaryContainerDark
import com.ml.fetchapplication.onPrimaryContainerDarkHighContrast
import com.ml.fetchapplication.onPrimaryContainerDarkMediumContrast
import com.ml.fetchapplication.onPrimaryContainerLight
import com.ml.fetchapplication.onPrimaryContainerLightHighContrast
import com.ml.fetchapplication.onPrimaryContainerLightMediumContrast
import com.ml.fetchapplication.onPrimaryDark
import com.ml.fetchapplication.onPrimaryDarkHighContrast
import com.ml.fetchapplication.onPrimaryDarkMediumContrast
import com.ml.fetchapplication.onPrimaryLight
import com.ml.fetchapplication.onPrimaryLightHighContrast
import com.ml.fetchapplication.onPrimaryLightMediumContrast
import com.ml.fetchapplication.onSecondaryContainerDark
import com.ml.fetchapplication.onSecondaryContainerDarkHighContrast
import com.ml.fetchapplication.onSecondaryContainerDarkMediumContrast
import com.ml.fetchapplication.onSecondaryContainerLight
import com.ml.fetchapplication.onSecondaryContainerLightHighContrast
import com.ml.fetchapplication.onSecondaryContainerLightMediumContrast
import com.ml.fetchapplication.onSecondaryDark
import com.ml.fetchapplication.onSecondaryDarkHighContrast
import com.ml.fetchapplication.onSecondaryDarkMediumContrast
import com.ml.fetchapplication.onSecondaryLight
import com.ml.fetchapplication.onSecondaryLightHighContrast
import com.ml.fetchapplication.onSecondaryLightMediumContrast
import com.ml.fetchapplication.onSurfaceDark
import com.ml.fetchapplication.onSurfaceDarkHighContrast
import com.ml.fetchapplication.onSurfaceDarkMediumContrast
import com.ml.fetchapplication.onSurfaceLight
import com.ml.fetchapplication.onSurfaceLightHighContrast
import com.ml.fetchapplication.onSurfaceLightMediumContrast
import com.ml.fetchapplication.onSurfaceVariantDark
import com.ml.fetchapplication.onSurfaceVariantDarkHighContrast
import com.ml.fetchapplication.onSurfaceVariantDarkMediumContrast
import com.ml.fetchapplication.onSurfaceVariantLight
import com.ml.fetchapplication.onSurfaceVariantLightHighContrast
import com.ml.fetchapplication.onSurfaceVariantLightMediumContrast
import com.ml.fetchapplication.onTertiaryContainerDark
import com.ml.fetchapplication.onTertiaryContainerDarkHighContrast
import com.ml.fetchapplication.onTertiaryContainerDarkMediumContrast
import com.ml.fetchapplication.onTertiaryContainerLight
import com.ml.fetchapplication.onTertiaryContainerLightHighContrast
import com.ml.fetchapplication.onTertiaryContainerLightMediumContrast
import com.ml.fetchapplication.onTertiaryDark
import com.ml.fetchapplication.onTertiaryDarkHighContrast
import com.ml.fetchapplication.onTertiaryDarkMediumContrast
import com.ml.fetchapplication.onTertiaryLight
import com.ml.fetchapplication.onTertiaryLightHighContrast
import com.ml.fetchapplication.onTertiaryLightMediumContrast
import com.ml.fetchapplication.outlineDark
import com.ml.fetchapplication.outlineDarkHighContrast
import com.ml.fetchapplication.outlineDarkMediumContrast
import com.ml.fetchapplication.outlineLight
import com.ml.fetchapplication.outlineLightHighContrast
import com.ml.fetchapplication.outlineLightMediumContrast
import com.ml.fetchapplication.outlineVariantDark
import com.ml.fetchapplication.outlineVariantDarkHighContrast
import com.ml.fetchapplication.outlineVariantDarkMediumContrast
import com.ml.fetchapplication.outlineVariantLight
import com.ml.fetchapplication.outlineVariantLightHighContrast
import com.ml.fetchapplication.outlineVariantLightMediumContrast
import com.ml.fetchapplication.primaryContainerDark
import com.ml.fetchapplication.primaryContainerDarkHighContrast
import com.ml.fetchapplication.primaryContainerDarkMediumContrast
import com.ml.fetchapplication.primaryContainerLight
import com.ml.fetchapplication.primaryContainerLightHighContrast
import com.ml.fetchapplication.primaryContainerLightMediumContrast
import com.ml.fetchapplication.primaryDark
import com.ml.fetchapplication.primaryDarkHighContrast
import com.ml.fetchapplication.primaryDarkMediumContrast
import com.ml.fetchapplication.primaryLight
import com.ml.fetchapplication.primaryLightHighContrast
import com.ml.fetchapplication.primaryLightMediumContrast
import com.ml.fetchapplication.scrimDark
import com.ml.fetchapplication.scrimDarkHighContrast
import com.ml.fetchapplication.scrimDarkMediumContrast
import com.ml.fetchapplication.scrimLight
import com.ml.fetchapplication.scrimLightHighContrast
import com.ml.fetchapplication.scrimLightMediumContrast
import com.ml.fetchapplication.secondaryContainerDark
import com.ml.fetchapplication.secondaryContainerDarkHighContrast
import com.ml.fetchapplication.secondaryContainerDarkMediumContrast
import com.ml.fetchapplication.secondaryContainerLight
import com.ml.fetchapplication.secondaryContainerLightHighContrast
import com.ml.fetchapplication.secondaryContainerLightMediumContrast
import com.ml.fetchapplication.secondaryDark
import com.ml.fetchapplication.secondaryDarkHighContrast
import com.ml.fetchapplication.secondaryDarkMediumContrast
import com.ml.fetchapplication.secondaryLight
import com.ml.fetchapplication.secondaryLightHighContrast
import com.ml.fetchapplication.secondaryLightMediumContrast
import com.ml.fetchapplication.surfaceBrightDark
import com.ml.fetchapplication.surfaceBrightDarkHighContrast
import com.ml.fetchapplication.surfaceBrightDarkMediumContrast
import com.ml.fetchapplication.surfaceBrightLight
import com.ml.fetchapplication.surfaceBrightLightHighContrast
import com.ml.fetchapplication.surfaceBrightLightMediumContrast
import com.ml.fetchapplication.surfaceContainerDark
import com.ml.fetchapplication.surfaceContainerDarkHighContrast
import com.ml.fetchapplication.surfaceContainerDarkMediumContrast
import com.ml.fetchapplication.surfaceContainerHighDark
import com.ml.fetchapplication.surfaceContainerHighDarkHighContrast
import com.ml.fetchapplication.surfaceContainerHighDarkMediumContrast
import com.ml.fetchapplication.surfaceContainerHighLight
import com.ml.fetchapplication.surfaceContainerHighLightHighContrast
import com.ml.fetchapplication.surfaceContainerHighLightMediumContrast
import com.ml.fetchapplication.surfaceContainerHighestDark
import com.ml.fetchapplication.surfaceContainerHighestDarkHighContrast
import com.ml.fetchapplication.surfaceContainerHighestDarkMediumContrast
import com.ml.fetchapplication.surfaceContainerHighestLight
import com.ml.fetchapplication.surfaceContainerHighestLightHighContrast
import com.ml.fetchapplication.surfaceContainerHighestLightMediumContrast
import com.ml.fetchapplication.surfaceContainerLight
import com.ml.fetchapplication.surfaceContainerLightHighContrast
import com.ml.fetchapplication.surfaceContainerLightMediumContrast
import com.ml.fetchapplication.surfaceContainerLowDark
import com.ml.fetchapplication.surfaceContainerLowDarkHighContrast
import com.ml.fetchapplication.surfaceContainerLowDarkMediumContrast
import com.ml.fetchapplication.surfaceContainerLowLight
import com.ml.fetchapplication.surfaceContainerLowLightHighContrast
import com.ml.fetchapplication.surfaceContainerLowLightMediumContrast
import com.ml.fetchapplication.surfaceContainerLowestDark
import com.ml.fetchapplication.surfaceContainerLowestDarkHighContrast
import com.ml.fetchapplication.surfaceContainerLowestDarkMediumContrast
import com.ml.fetchapplication.surfaceContainerLowestLight
import com.ml.fetchapplication.surfaceContainerLowestLightHighContrast
import com.ml.fetchapplication.surfaceContainerLowestLightMediumContrast
import com.ml.fetchapplication.surfaceDark
import com.ml.fetchapplication.surfaceDarkHighContrast
import com.ml.fetchapplication.surfaceDarkMediumContrast
import com.ml.fetchapplication.surfaceDimDark
import com.ml.fetchapplication.surfaceDimDarkHighContrast
import com.ml.fetchapplication.surfaceDimDarkMediumContrast
import com.ml.fetchapplication.surfaceDimLight
import com.ml.fetchapplication.surfaceDimLightHighContrast
import com.ml.fetchapplication.surfaceDimLightMediumContrast
import com.ml.fetchapplication.surfaceLight
import com.ml.fetchapplication.surfaceLightHighContrast
import com.ml.fetchapplication.surfaceLightMediumContrast
import com.ml.fetchapplication.surfaceVariantDark
import com.ml.fetchapplication.surfaceVariantDarkHighContrast
import com.ml.fetchapplication.surfaceVariantDarkMediumContrast
import com.ml.fetchapplication.surfaceVariantLight
import com.ml.fetchapplication.surfaceVariantLightHighContrast
import com.ml.fetchapplication.surfaceVariantLightMediumContrast
import com.ml.fetchapplication.tertiaryContainerDark
import com.ml.fetchapplication.tertiaryContainerDarkHighContrast
import com.ml.fetchapplication.tertiaryContainerDarkMediumContrast
import com.ml.fetchapplication.tertiaryContainerLight
import com.ml.fetchapplication.tertiaryContainerLightHighContrast
import com.ml.fetchapplication.tertiaryContainerLightMediumContrast
import com.ml.fetchapplication.tertiaryDark
import com.ml.fetchapplication.tertiaryDarkHighContrast
import com.ml.fetchapplication.tertiaryDarkMediumContrast
import com.ml.fetchapplication.tertiaryLight
import com.ml.fetchapplication.tertiaryLightHighContrast
import com.ml.fetchapplication.tertiaryLightMediumContrast

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
fun FetchApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable() () -> Unit
) {
    // To turn off dyanmic color, replace "dyamicColor" in the line below with false
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

