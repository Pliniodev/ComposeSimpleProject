package com.pliniodev.composesimpleproject.view.details

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.pliniodev.composesimpleproject.presentation.model.BreedPresentation
import com.pliniodev.composesimpleproject.ui.theme.RoundedCornerShapes
import com.pliniodev.composesimpleproject.view.component.FullDogImage
import com.pliniodev.composesimpleproject.view.component.TextForDescription
import com.pliniodev.composesimpleproject.view.component.default.DefaultTopAppBar

class DogDetailsScreen(private val selectedDog: BreedPresentation) : Screen {

    @Composable
    override fun Content() {
        Scaffold(
            topBar = { DefaultTopAppBar("Breed Details") }
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
            ) {
                FullDogImage(selectedDog.image?.url)

                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .border(
                                border = BorderStroke(1.dp, Color.LightGray),
                                shape = RoundedCornerShapes.small
                            )
                            .padding(16.dp)
                    ) {
                        selectedDog.name?.let { name ->
                            TextForDescription(
                                title = "Name: ",
                                description = name
                            )
                        }
                        selectedDog.height?.metric?.let { metricHeight ->
                            TextForDescription(
                                title = "Height(Metric): ",
                                description = "$metricHeight cm"
                            )
                        }
                        selectedDog.temperament?.let { temperament ->
                            TextForDescription(
                                title = "Temperament: ",
                                description = temperament
                            )
                        }
                    }
                }
            }
        }
    }
}
