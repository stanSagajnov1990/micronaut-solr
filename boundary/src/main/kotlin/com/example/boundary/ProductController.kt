package com.example.boundary;

import com.example.boundary.dto.incoming.ProductInDto
import com.example.boundary.dto.mapper.ProductOutDtoMapper
import com.example.boundary.dto.outgoing.DetailOutDto
import com.example.boundary.dto.outgoing.ProductOutDto
import com.example.domain.ProductDetailService
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import jakarta.inject.Inject

@Controller("/api/product/detail")
class ProductController {

    @Inject
    private lateinit var productDetailService: ProductDetailService

    @Inject
    private lateinit var productDtoMapper: ProductOutDtoMapper

    @Get(produces = [MediaType.APPLICATION_JSON], uri = "/{sku}")
    fun index(sku: String): ProductOutDto {
        val productDetail = productDetailService.getProductDetail(sku)
        return productDtoMapper.productDetailToProductOutDto(productDetail)
    }

    @Post(uri = "/add")
    fun post(@Body productInDto: ProductInDto): ProductOutDto {
        val productDetail = productDtoMapper.productInDtoToProductDetail(productInDto)
        productDetail.id = productDetail.sku

        productDetailService.saveProductDetail(productDetail)
        return productDtoMapper.productDetailToProductOutDto(productDetail)
    }
}
