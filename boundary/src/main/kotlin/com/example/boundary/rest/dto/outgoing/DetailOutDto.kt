package com.example.boundary.rest.dto.outgoing

import io.micronaut.core.annotation.Introspected

@Introspected
data class DetailOutDto(
    val title: String,
    val description: String,
    val price: Int,
    val currency: String,
    val averagePrice: Float,
    val lowestPrice: Float,
    val highestPrice: Float,
    val medianPrice: Float,
    val occurrenceCount: Int
)
