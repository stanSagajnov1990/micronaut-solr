package com.example.boundary;

import com.example.boundary.dto.DetailDto
import com.example.boundary.dto.ProductDto
import com.example.domain.ProductDetailService
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import jakarta.inject.Inject

@Controller("/api/product/detail")
class ProductController {

    @Inject
    private lateinit var productDetailService: ProductDetailService

    @Get(produces = [MediaType.APPLICATION_JSON], uri = "/{sku}")
    fun index(sku: String): ProductDto {
        productDetailService.getProductDetail(sku)
        return ProductDto(sku = "cement", detail = DetailDto("5kg Zement", "", 5, "EUR"))
    }

    @Post(uri = "/add")
    fun post() {
//        productDetailService.addProductDetail()
    }
}
