package com.example.domain

import com.example.domain.mapper.ProductDetailMapper
import com.example.solr.SolrRepository
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class ProductDetailService {

    @Inject private lateinit var solrRepository: SolrRepository

    @Inject private lateinit var productDetailMapper: ProductDetailMapper

    fun addProductDetail(productDocument: ProductDetail)//: ProductDetail {
    {
        val productDocument1 = productDetailMapper.productDetailToProductDocument(productDocument)
        return solrRepository.add(productDocument1)
    }

    fun getProductDetail(sku: String): ProductDetail {
        val productDocument = solrRepository.findOneBySku(sku)
        return productDetailMapper.authorToAuthorDto(productDocument)
    }
}
