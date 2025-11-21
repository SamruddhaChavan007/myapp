package com.example.myintro.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.googlefonts.GoogleFont.Provider
import androidx.compose.ui.text.googlefonts.Font
import com.example.myintro.R

// 1) Google Fonts provider (equivalent to the font provider in the doc)
private val googleFontProvider = Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

// 2) Pick a Google font by name (must exist on fonts.google.com)
private val robotoFont = GoogleFont("Roboto")
private val pacificoFont = GoogleFont("Pacifico")
private val georgiaFont = GoogleFont("Georgia")

// 3) Expose a FontFamily using downloadable fonts
val RobotoFontFamily = FontFamily(
    Font(
        googleFont = robotoFont,
        fontProvider = googleFontProvider,
        weight = FontWeight.Normal,
        style = FontStyle.Normal
    ),
    Font(
        googleFont = robotoFont,
        fontProvider = googleFontProvider,
        weight = FontWeight.Bold,
        style = FontStyle.Normal
    )
)

val PacificoFontFamily = FontFamily(
    Font(
        googleFont = pacificoFont,
        fontProvider = googleFontProvider,
        weight = FontWeight.Normal,
        style = FontStyle.Normal
    )
)

val GeorgiaFontFamily = FontFamily(
    Font(
        googleFont = georgiaFont,
        fontProvider = googleFontProvider,
        weight = FontWeight.Normal,
        style = FontStyle.Normal
    )
)