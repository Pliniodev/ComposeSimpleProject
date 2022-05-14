package com.pliniodev.composesimpleproject.view.doglist

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.pliniodev.composesimpleproject.presentation.model.BreedPresentation
import com.pliniodev.composesimpleproject.view.component.DogCard
import com.pliniodev.composesimpleproject.view.details.DogDetailsScreen

@Composable
fun DogCardEntry(breedPresentation: BreedPresentation) {
    val navigator = LocalNavigator.currentOrThrow
    DogCard(
        onClick = { navigator.push(DogDetailsScreen(breedPresentation)) },
        presentation = breedPresentation
    )
}
