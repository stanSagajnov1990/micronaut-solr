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
        productDetailService.addProductDetail(ProductDetail("sku-1", "sku-1", Detail("sku-1", "sku-1", 1, "EUR", 1, 1, 1, 1, 1)))
    }

    @Test
    fun getProductDetail() {
        productDetailService.getProductDetail("sku-1")
    }
}