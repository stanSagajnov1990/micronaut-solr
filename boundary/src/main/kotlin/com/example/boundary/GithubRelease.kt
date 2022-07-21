package com.example.boundary

import io.micronaut.core.annotation.Introspected

@Introspected
data class GithubRelease(
    val sku: String,
    val averagePrice: Double,
    val lowestPrice: Double,
    val highestPrice: Double,
    val medianPrice: Double,
    val occurrenceCount: Int
)
