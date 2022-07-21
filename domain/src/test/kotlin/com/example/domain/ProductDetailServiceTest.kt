package com.example.domain

import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

@MicronautTest
internal class ProductDetailServiceTest {

    @Inject
    lateinit var productDetailService: ProductDetailService


    @Test
    fun saveProductDetail() {
        val skuId = "sku-1123"
        val productDetail = productDetailService.getProductDetail(skuId)

        productDetailService.saveProductDetail(ProductDetail("sku-1123", skuId, Detail("sku-1", "sku-1",
            1.0, "EUR", 1.0, 1.0, 1.0, 1.0, 1)))

        //assertions
        val productDetail2 = productDetailService.getProductDetail(skuId)
        Assertions.assertThat(productDetail2).isNotNull

        //clean up
        productDetailService.removeProductDetail(productDetail2!!)
    }

    @Test
    fun getProductDetail() {
        val productDetail = productDetailService.getProductDetail("sku-1")

        Assertions.assertThat(productDetail?.sku).isEqualTo("sku-1")
    }
}