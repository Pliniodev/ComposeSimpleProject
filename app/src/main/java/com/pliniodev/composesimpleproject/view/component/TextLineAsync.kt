package com.pliniodev.composesimpleproject.view.component

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle

@Composable
fun TextLineAsync(text: String, textAnnotated: String? = null) {
    Text(
        buildAnnotatedString {
            append(text)
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.W900,
                    color = Color(0xFF4552B8)
                )
            ) { textAnnotated?.let(::append) }
        }
    )
}