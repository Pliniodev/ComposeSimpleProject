package com.pliniodev.composesimpleproject.domain.mapper


import com.pliniodev.composesimpleproject.domain.Breed
import com.pliniodev.composesimpleproject.domain.Height
import com.pliniodev.composesimpleproject.domain.Image
import com.pliniodev.composesimpleproject.domain.Weight
import com.pliniodev.composesimpleproject.presentation.model.BreedPresentation
import com.pliniodev.composesimpleproject.presentation.model.HeightPresentation
import com.pliniodev.composesimpleproject.presentation.model.ImagePresentation
import com.pliniodev.composesimpleproject.presentation.model.WeightPresentation

internal object BreedsDomainMapper {

    fun toBreedsPresentation(source: List<Breed>): List<BreedPresentation> {
        return source.map { Breed ->
            with(Breed) {
                BreedPresentation(
                    altNames = altNames,
                    id = id,
                    lifeSpan = lifeSpan,
                    referenceImageId = referenceImageId,
                    shortLegs = shortLegs,
                    suppressedTail = suppressedTail,
                    wikipediaUrl = wikipediaUrl,
                    experimental = experimental,
                    hairless = hairless,
                    hypoallergenic = hypoallergenic,
                    name = name,
                    natural = natural,
                    origin = origin,
                    rare = rare,
                    rex = rex,
                    temperament = temperament,
                    weight = toWeightPresentation(weight),
                    height = toHeightPresentation(height),
                    image = toImagePresentation(image)
                )
            }
        }
    }

    private fun toImagePresentation(imageDomain: Image?): ImagePresentation =
        ImagePresentation(
            id = imageDomain?.id,
            height = imageDomain?.height,
            width = imageDomain?.width,
            url = imageDomain?.url
        )

    private fun toHeightPresentation(heightDomain: Height?): HeightPresentation =
        HeightPresentation(
            imperial = heightDomain?.imperial,
            metric = heightDomain?.metric
        )

    private fun toWeightPresentation(weightDomain: Weight?): WeightPresentation =
        WeightPresentation(
            imperial = weightDomain?.imperial,
            metric = weightDomain?.metric
        )
}
