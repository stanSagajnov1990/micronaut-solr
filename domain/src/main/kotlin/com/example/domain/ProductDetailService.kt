package com.example.domain

import com.example.domain.mapper.ProductDetailMapper
import com.example.solr.SolrRepository
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class ProductDetailService {

    @Inject private lateinit var solrRepository: SolrRepository

    @Inject private lateinit var productDetailMapper: ProductDetailMapper

    fun saveProductDetail(productDocument: ProductDetail) {
        val productDocument1 = productDetailMapper.productDetailToProductDocument(productDocument)
        return solrRepository.add(productDocument1)
    }

    fun removeProductDetail(productDetail: ProductDetail) {
        if (productDetail.id == null)
            throw RuntimeException("the supplied productDetail doesn't possess an id")

        solrRepository.deleteById(productDetail.id!!)
    }

    fun getProductDetail(sku: String): ProductDetail? {
        val productDocument = solrRepository.findOneBySku(sku)

        return if (productDocument != null) {
            productDetailMapper.authorToAuthorDto(productDocument)
        } else {
            null
        }
    }

    fun getProductDetails(start: Int, rows:Int): List<ProductDetail> {
        val productDetails =  solrRepository.findByRange(start, rows)
        return productDetails.map { productDetailMapper.authorToAuthorDto(it) }
    }
}
