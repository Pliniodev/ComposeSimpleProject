package com.pliniodev.composesimpleproject.view.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.pliniodev.composesimpleproject.ui.theme.RoundedCornerShapes

@Composable
fun FullDogImage(url: String?) {
    val cardPadding = 20.dp
    Card(
        modifier = Modifier
            .padding(cardPadding)
            .padding(bottom = 16.dp),
        elevation = 4.dp,
        border = BorderStroke(width = 1.dp, Color.Transparent),
        shape = RoundedCornerShapes.small
    ) {
        SubcomposeAsyncImage(
            model = url,
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clip(RoundedCornerShapes.small),
            contentScale = ContentScale.FillWidth
        ) {
            val state = painter.state
            if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                Row(
                    Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(48.dp),
                        Color.Green,
                        2.dp
                    )
                }
            } else {
                SubcomposeAsyncImageContent()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FullDogImageTest() {
    FullDogImage(url = "")
}
