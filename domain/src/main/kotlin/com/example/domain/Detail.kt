package com.example.domain

data class Detail (
    val title: String,
    val description: String,
    val price: Double,
    val currency: String,
    var averagePrice: Double,
    var lowestPrice: Double,
    var highestPrice: Double,
    var medianPrice: Double,
    var occurrenceCount: Int
)
