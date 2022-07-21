package com.example.domain

import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Test

@MicronautTest
internal class ProductDetailServiceTest {

    @Inject
    lateinit var productDetailService: ProductDetailService


    @Test
    fun addProductDetail() {
//        val productDetail = productDetailService.getProductDetail("1123")

        productDetailService.saveProductDetail(ProductDetail("sku-1123", "sku-1123", Detail("sku-1", "sku-1",
            1.0, "EUR", 1.0, 1.0, 1.0, 1.0, 1)))
    }

    @Test
    fun getProductDetail() {
        productDetailService.getProductDetail("sku-1")
    }
}