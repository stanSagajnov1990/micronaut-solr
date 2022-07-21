package com.example.boundary.cronjob

import io.micronaut.core.annotation.Introspected

@Introspected
data class PricesDTO(
    val sku: String,
    val averagePrice: Double,
    val lowestPrice: Double,
    val highestPrice: Double,
    val medianPrice: Double,
    val occurrenceCount: Int
)
