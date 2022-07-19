package com.example.solr.data

import org.apache.solr.client.solrj.beans.Field

data class DetailData @JvmOverloads constructor(
    @Field
    var id: String? = null,
    @Field
    var title: String? = null,
    @Field
    var description: String? = null,
    @Field
    var price: Int = 0,
    @Field
    var averagePrice: Int = 0,
    @Field
    var currency: String? = null,
    @Field
    var lowestPrice: Int = 0,
    @Field
    var highestPrice: Int = 0,
    @Field
    var medianPricer: Int = 0,
    @Field
    var occurrenceCount: Int = 0
)
