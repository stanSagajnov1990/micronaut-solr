package com.example.solr.data

import org.apache.solr.client.solrj.beans.Field

data class DetailData(
    @Field
    val title: String,
    @Field
    val description: String,
    @Field
    val price: Int,
    @Field
    val averagePrice: Int,
    @Field
    val currency: String,
    @Field
    val lowestPrice: Int,
    @Field
    val highestPrice: Int,
    @Field
    val medianPricer: Int,
    @Field
    val occurrenceCount: Int
)
