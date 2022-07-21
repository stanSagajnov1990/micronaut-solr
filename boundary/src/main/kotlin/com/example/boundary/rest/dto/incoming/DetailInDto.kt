package com.example.boundary.rest.dto.incoming

import io.micronaut.core.annotation.Introspected

@Introspected
class DetailInDto (
    val title: String,
    val description: String,
    val price: Double,
    val currency: String,
    val averagePrice: Double,
    val lowestPrice: Double,
    val highestPrice: Double,
    val medianPrice: Double,
    val occurrenceCount: Int
)