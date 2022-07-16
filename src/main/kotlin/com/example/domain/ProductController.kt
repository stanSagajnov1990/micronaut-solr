package com.example.domain;

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import jakarta.inject.Inject

@Controller("/api/product/detail")
class ProductController {

    @Inject
    private lateinit var productDetailService: ProductDetailService

    @Get(produces = [MediaType.TEXT_PLAIN], uri = "/{sku}")
    fun index(sku: String): String {
        return "Hello World" + sku
    }

    @Post(uri = "/add")
    fun post() {

    }
}
