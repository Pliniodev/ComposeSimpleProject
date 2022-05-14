package com.pliniodev.composesimpleproject.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.pliniodev.composesimpleproject.presentation.model.BreedPresentation

@Composable
fun DogCard(onClick: () -> Unit, presentation: BreedPresentation){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .background(color = Color.DarkGray),
            verticalAlignment = Alignment.CenterVertically
        ) {

            FadeImage(presentation.image?.url)

            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .fillMaxWidth()
                    .padding(15.dp)
                    .background(color = Color.Gray),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                TextLineAsync("Breed: ", presentation.name)
                TextLineAsync("Life span: ", presentation.lifeSpan)
            }
        }
    }
}