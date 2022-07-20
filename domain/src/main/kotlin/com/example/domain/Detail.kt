package com.example.domain

data class Detail (
    val title: String,
    val description: String,
    val price: Int,
    val currency: String,
    val averagePrice: Int,
    val lowestPrice: Int,
    val highestPrice: Int,
    val medianPrice: Int,
    val occurrenceCount: Int
)
