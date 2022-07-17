package com.example.solr.data

import org.apache.solr.client.solrj.beans.Field

class ProductDocument (
    @Field
    val sku: String,
    @Field(child = true)
    val detail: DetailData
)
