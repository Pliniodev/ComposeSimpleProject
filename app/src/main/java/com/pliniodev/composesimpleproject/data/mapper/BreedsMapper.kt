package com.pliniodev.composesimpleproject.data.mapper

import com.pliniodev.composesimpleproject.data.response.BreedResponse
import com.pliniodev.composesimpleproject.data.response.HeightResponse
import com.pliniodev.composesimpleproject.data.response.ImageResponse
import com.pliniodev.composesimpleproject.data.response.WeightResponse
import com.pliniodev.composesimpleproject.domain.Breed
import com.pliniodev.composesimpleproject.domain.Height
import com.pliniodev.composesimpleproject.domain.Image
import com.pliniodev.composesimpleproject.domain.Weight

internal object BreedsMapper {

    fun toBreedsDomain(source: List<BreedResponse>): List<Breed> {
        return source.map { Breed ->
            with(Breed) {
                Breed(
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
                    weight = toWeightDomain(weight),
                    height = toHeightDomain(height),
                    image = toImageDomain(image)
                )
            }
        }
    }

    private fun toImageDomain(imageResponse: ImageResponse?): Image =
        Image(
            id = imageResponse?.id,
            height = imageResponse?.height,
            width = imageResponse?.width,
            url = imageResponse?.url
        )

    private fun toHeightDomain(heightResponse: HeightResponse?): Height =
        Height(
            imperial = heightResponse?.imperial,
            metric = heightResponse?.metric
        )

    private fun toWeightDomain(weightResponse: WeightResponse?): Weight =
        Weight(
            imperial = weightResponse?.imperial,
            metric = weightResponse?.metric
        )
}
