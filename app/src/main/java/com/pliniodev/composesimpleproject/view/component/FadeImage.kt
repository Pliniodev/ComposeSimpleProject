package com.pliniodev.composesimpleproject.view.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation

@Composable
fun FadeImage(url: String?) {
    val painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current)
            .data(data = url)
            .apply(block = fun ImageRequest.Builder.() {
                crossfade(500)
                transformations(CircleCropTransformation())
            }).build()
    )
    Image(
        painter = painter,
        contentDescription = "",
        modifier = Modifier
            .size(60.dp)
            .clip(CircleShape)
    )
}