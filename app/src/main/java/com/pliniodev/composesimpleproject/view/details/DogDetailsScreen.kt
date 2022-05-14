package com.pliniodev.composesimpleproject.view.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.pliniodev.composesimpleproject.presentation.model.BreedPresentation
import com.pliniodev.composesimpleproject.view.component.FullDogImage
import com.pliniodev.composesimpleproject.view.component.TextWithAnnotated
import com.pliniodev.composesimpleproject.view.component.default.DefaultTopAppBar

class DogDetailsScreen(selectedDog: BreedPresentation) : Screen {

    private val dog = selectedDog

    @Composable
    override fun Content() {
        Scaffold(
            topBar = { DefaultTopAppBar("DogDetails") }
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
            ) {
                FullDogImage(dog.image?.url)

                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {
                    Column(Modifier.fillMaxWidth()) {
                        dog.name?.let { TextWithAnnotated(text = "Name: ", it) }
                        dog.height?.metric?.let {
                            TextWithAnnotated(text = "Height(Metric): ", "$it cm")
                        }
                        dog.temperament?.let { TextWithAnnotated(text = "Temperament: ", it) }
                    }
                }
            }
        }
    }
}
