package com.example.boundary.rest.dto.mapper

import com.example.boundary.rest.dto.incoming.ProductInDto
import com.example.boundary.rest.dto.outgoing.ProductOutDto
import com.example.domain.ProductDetail
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "jsr330", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface ProductOutDtoMapper {

    fun productDetailToProductOutDto(productDetail: ProductDetail): ProductOutDto

    fun productInDtoToProductDetail(productDetail: ProductInDto): ProductDetail

}