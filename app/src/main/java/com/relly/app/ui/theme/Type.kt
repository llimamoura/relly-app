package com.relly.app.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.relly.app.R

// ─── DM Sans via Google Fonts ─────────────────────────────────────────────────
// Requires res/values/font_certs.xml with GMS certificates.
// To generate: Android Studio > res/font > New > Font Resource File > Downloadable font > "DM Sans"
private val fontProvider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage   = "com.google.android.gms",
    certificates      = R.array.com_google_android_gms_fonts_certs,
)

private val DmSansFont = GoogleFont("DM Sans")

val DmSansFamily = FontFamily(
    Font(googleFont = DmSansFont, fontProvider = fontProvider, weight = FontWeight.Normal),
    Font(googleFont = DmSansFont, fontProvider = fontProvider, weight = FontWeight.Medium),
    Font(googleFont = DmSansFont, fontProvider = fontProvider, weight = FontWeight.SemiBold),
    Font(googleFont = DmSansFont, fontProvider = fontProvider, weight = FontWeight.Bold),
)

// ─── Material 3 Typography ────────────────────────────────────────────────────
val RellyTypography = Typography(
    // Display
    displayLarge = TextStyle(
        fontFamily   = DmSansFamily,
        fontWeight   = FontWeight.Normal,
        fontSize     = 57.sp,
        lineHeight   = 64.sp,
        letterSpacing = (-0.25).sp,
    ),
    displayMedium = TextStyle(
        fontFamily   = DmSansFamily,
        fontWeight   = FontWeight.Normal,
        fontSize     = 45.sp,
        lineHeight   = 52.sp,
        letterSpacing = 0.sp,
    ),
    displaySmall = TextStyle(
        fontFamily   = DmSansFamily,
        fontWeight   = FontWeight.Normal,
        fontSize     = 36.sp,
        lineHeight   = 44.sp,
        letterSpacing = 0.sp,
    ),
    // Headline
    headlineLarge = TextStyle(
        fontFamily   = DmSansFamily,
        fontWeight   = FontWeight.SemiBold,
        fontSize     = 32.sp,
        lineHeight   = 40.sp,
        letterSpacing = 0.sp,
    ),
    headlineMedium = TextStyle(
        fontFamily   = DmSansFamily,
        fontWeight   = FontWeight.SemiBold,
        fontSize     = 28.sp,
        lineHeight   = 36.sp,
        letterSpacing = 0.sp,
    ),
    headlineSmall = TextStyle(
        fontFamily   = DmSansFamily,
        fontWeight   = FontWeight.SemiBold,
        fontSize     = 24.sp,
        lineHeight   = 32.sp,
        letterSpacing = 0.sp,
    ),
    // Title
    titleLarge = TextStyle(
        fontFamily   = DmSansFamily,
        fontWeight   = FontWeight.SemiBold,
        fontSize     = 22.sp,
        lineHeight   = 28.sp,
        letterSpacing = 0.sp,
    ),
    titleMedium = TextStyle(
        fontFamily   = DmSansFamily,
        fontWeight   = FontWeight.Medium,
        fontSize     = 16.sp,
        lineHeight   = 24.sp,
        letterSpacing = 0.15.sp,
    ),
    titleSmall = TextStyle(
        fontFamily   = DmSansFamily,
        fontSize     = 14.sp,
        lineHeight   = 20.sp,
        letterSpacing = 0.1.sp,
    ),
    // Body
    bodyLarge = TextStyle(
        fontFamily   = DmSansFamily,
        fontWeight   = FontWeight.Normal,
        fontSize     = 16.sp,
        lineHeight   = 24.sp,
        letterSpacing = 0.5.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily   = DmSansFamily,
        fontWeight   = FontWeight.Normal,
        fontSize     = 14.sp,
        lineHeight   = 20.sp,
        letterSpacing = 0.25.sp,
    ),
    bodySmall = TextStyle(
        fontFamily   = DmSansFamily,
        fontWeight   = FontWeight.Normal,
        fontSize     = 12.sp,
        lineHeight   = 16.sp,
        letterSpacing = 0.4.sp,
    ),
    // Label
    labelLarge = TextStyle(
        fontFamily   = DmSansFamily,
        fontWeight   = FontWeight.Medium,
        fontSize     = 14.sp,
        lineHeight   = 20.sp,
        letterSpacing = 0.1.sp,
    ),
    labelMedium = TextStyle(
        fontFamily   = DmSansFamily,
        fontWeight   = FontWeight.Medium,
        fontSize     = 12.sp,
        lineHeight   = 16.sp,
        letterSpacing = 0.5.sp,
    ),
    labelSmall = TextStyle(
        fontFamily   = DmSansFamily,
        fontWeight   = FontWeight.Medium,
        fontSize     = 11.sp,
        lineHeight   = 16.sp,
        letterSpacing = 0.5.sp,
    ),
)
