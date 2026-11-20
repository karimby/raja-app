package com.raja.fans.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// ألوان الرجاء: الأخضر والأبيض
val RajaGreen = Color(0xFF0B6B3A)

private val RajaColors = lightColorScheme(
    primary = RajaGreen,
    onPrimary = Color.White,
    secondary = Color(0xFF2E9E5B),
    background = Color(0xFFF4F7F5),
    surface = Color.White,
)

@Composable
fun RajaTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = RajaColors, content = content)
}
