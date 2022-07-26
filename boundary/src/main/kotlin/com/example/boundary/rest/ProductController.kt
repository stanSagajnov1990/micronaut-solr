package com.example.boundary.rest;

import com.example.boundary.rest.dto.incoming.ProductInDto
import com.example.boundary.rest.dto.mapper.ProductOutDtoMapper
import com.example.boundary.rest.dto.outgoing.DetailOutDto
import com.example.boundary.rest.dto.outgoing.ProductOutDto
import com.example.domain.ProductDetailService
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.hateoas.JsonError
import jakarta.inject.Inject

@Controller("/api/product")
class ProductController {

    @Inject
    private lateinit var productDetailService: ProductDetailService

    @Inject
    private lateinit var productDtoMapper: ProductOutDtoMapper

    @Post(uri = "/add")
    fun post(@Body productInDto: ProductInDto): ProductOutDto {
        val productDetail = productDtoMapper.productInDtoToProductDetail(productInDto)
        productDetail.id = productDetail.sku

        productDetailService.saveProductDetail(productDetail)
        return productDtoMapper.productDetailToProductOutDto(productDetail)
    }
}
