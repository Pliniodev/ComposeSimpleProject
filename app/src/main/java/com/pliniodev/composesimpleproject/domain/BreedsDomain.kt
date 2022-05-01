package com.pliniodev.composesimpleproject.domain

data class Breed(
    val altNames: String? = null,
    val id: Int? = null,
    val lifeSpan: String? = null,
    val referenceImageId: String? = null,
    val shortLegs: Int? = null,
    val suppressedTail: Int? = null,
    val wikipediaUrl: String? = null,
    val experimental: Int? = null,
    val hairless: Int? = null,
    val hypoallergenic: Int? = null,
    val name: String? = null,
    val natural: Int? = null,
    val origin: String? = null,
    val rare: Int? = null,
    val rex: Int? = null,
    val temperament: String? = null,
    val weight: Weight? = null,
    val height: Height? = null,
    val image: Image? = null
)

data class Weight(
    val imperial: String? = null,
    val metric: String? = null
)

data class Height(
    val imperial: String? = null,
    val metric: String? = null
)

data class Image(
    val height: Int? = null,
    val id: String? = null,
    val url: String? = null,
    val width: String? = null
)
