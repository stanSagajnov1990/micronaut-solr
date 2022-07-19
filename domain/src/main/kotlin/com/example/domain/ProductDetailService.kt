package com.example.domain

import com.example.solr.SolrRepository
import com.example.solr.data.ProductDocument
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class ProductDetailService {

    @Inject private lateinit var solrRepository: SolrRepository

    fun addProductDetail(productDocument: ProductDocument) {
        solrRepository.add(productDocument)
    }

    fun getProductDetail(sku: String) {
//        solrRepository.findBySku(sku)
    }
}
