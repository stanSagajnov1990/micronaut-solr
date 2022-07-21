package com.example.boundary.rest;

import com.example.boundary.rest.dto.mapper.ProductOutDtoMapper
import com.example.domain.ProductDetailService
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.hateoas.JsonError
import jakarta.inject.Inject

@Controller("/api/product/detail")
class ProductDetailController {

    @Inject
    private lateinit var productDetailService: ProductDetailService

    @Inject
    private lateinit var productDtoMapper: ProductOutDtoMapper

    @Get(produces = [MediaType.APPLICATION_JSON], uri = "/{sku}")
    fun index(sku: String): HttpResponse<*> {
        val productDetail = productDetailService.getProductDetail(sku)

        return if (productDetail == null)
            HttpResponse.notFound<JsonError>()
        else
            HttpResponse.ok(productDtoMapper.productDetailToProductOutDto(productDetail))
    }
}
