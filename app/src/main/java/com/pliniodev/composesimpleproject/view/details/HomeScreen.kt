package com.pliniodev.composesimpleproject.view.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.pliniodev.composesimpleproject.presentation.model.BreedPresentation
import com.pliniodev.composesimpleproject.presentation.model.HeightPresentation
import com.pliniodev.composesimpleproject.presentation.model.ImagePresentation
import com.pliniodev.composesimpleproject.presentation.model.WeightPresentation
import com.pliniodev.composesimpleproject.view.home.DogsHomeViewModel
import org.koin.androidx.compose.getViewModel

class DetailsScreen(breed: BreedPresentation) : Screen {
    val breed = BreedPresentation(
        altNames = "",
        id = 1,
        lifeSpan = "",
        referenceImageId = "",
        shortLegs = 1,
        suppressedTail = 1,
        wikipediaUrl = "",
        experimental = 1,
        hairless = 1,
        hypoallergenic = 1,
        name = "",
        natural = 1,
        origin = "",
        rare = 1,
        rex = 1,
        temperament = "",
        weight = WeightPresentation(imperial = "1", metric = "1"),
        height = HeightPresentation(imperial = "1", metric = "1"),
        image = ImagePresentation(
            height = 1199,
            id = "1",
            url = "https://cdn2.thedogapi.com/images/BJa4kxc4X.jpg",
            width = "1600"
        ),
    )

    @Composable
    override fun Content() {

        Column {

            Spacer(Modifier.size(4.dp))
        }
    }
}