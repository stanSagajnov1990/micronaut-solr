package com.example.domain

import com.example.solr.SolrRepository
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class ProductDetailService {

    @Inject private lateinit var solrRepository: SolrRepository
}
