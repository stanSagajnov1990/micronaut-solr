package com.example.domain

import com.example.solr.SolrService
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class ProductDetailService {

    @Inject private lateinit var solrService: SolrService
}
