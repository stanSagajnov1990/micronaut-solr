package com.example.boundary.dto.mapper

import com.example.boundary.dto.out.ProductOutDto
import com.example.domain.ProductDetail
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "jsr330", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface ProductOutDtoMapper {

    fun productDetailToProductOutDto(productDetail: ProductDetail): ProductOutDto

}