package com.pliniodev.composesimpleproject.view.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp

@Composable
fun TextForDescription(title: String, description: String? = null) {
    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.W900,
                    color = Color(0xFF4552B8)
                )
            ) {
                append(title)
            }
            description?.let(::append)
        },
        modifier = Modifier.padding(bottom = 4.dp),
        maxLines = 3,
    )
}
