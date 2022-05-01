package com.pliniodev.composesimpleproject.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BoxedText(text: String) {
    Box {
        Text(
            text = text,
            fontSize = 32.sp,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(
                    start = 36.dp,
                    end = 36.dp
                )
        )
    }
}