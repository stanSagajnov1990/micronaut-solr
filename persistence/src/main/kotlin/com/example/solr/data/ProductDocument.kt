package com.example.solr.data

import org.apache.solr.client.solrj.beans.Field

class ProductDocument @JvmOverloads constructor(
    @Field
    var id: String? = null,

    @Field
    var sku: String? = null,

    @Field
    var title: String? = null,

    @Field
    var description: String? = null,

    @Field
    var price: Float? = null,

    @Field
    var currency: String? = null,

    @Field("averageprice")
    var averagePrice: Float? = null,

    @Field("lowestprice")
    var lowestPrice: Float? = null,

    @Field("highestprice")
    var highestPrice: Float? = null,

    @Field("medianprice")
    var medianPrice: Float? = null,

    @Field("occurencecount")
    var occurrenceCount: Int? = null,

)
