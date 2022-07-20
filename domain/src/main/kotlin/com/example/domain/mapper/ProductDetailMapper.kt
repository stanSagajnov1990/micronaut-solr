package com.example.domain.mapper

import com.example.domain.Detail
import com.example.domain.ProductDetail
import com.example.solr.data.ProductDocument
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "jsr330", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface ProductDetailMapper {

    @Mapping(source = "title", target = "detail.title")
    @Mapping(source = "description", target = "detail.description")
    @Mapping(source = "price", target = "detail.price")
    @Mapping(source = "currency", target = "detail.currency")
    @Mapping(source = "averagePrice", target = "detail.averagePrice")
    @Mapping(source = "lowestPrice", target = "detail.lowestPrice")
    @Mapping(source = "highestPrice", target = "detail.highestPrice")
    @Mapping(source = "medianPrice", target = "detail.medianPrice")
    @Mapping(source = "occurrenceCount", target = "detail.occurrenceCount")
    fun authorToAuthorDto(
        author: ProductDocument
    ): ProductDetail

    @Mapping(target = "title", source = "detail.title")
    @Mapping(target = "description", source = "detail.description")
    @Mapping(target = "price", source = "detail.price")
    @Mapping(target = "currency", source = "detail.currency")
    @Mapping(target = "averagePrice", source = "detail.averagePrice")
    @Mapping(target = "lowestPrice", source = "detail.lowestPrice")
    @Mapping(target = "highestPrice", source = "detail.highestPrice")
    @Mapping(target = "medianPrice", source = "detail.medianPrice")
    @Mapping(target = "occurrenceCount", source = "detail.occurrenceCount")
    fun productDetailToProductDocument(
        author: ProductDetail
    ): ProductDocument
//    {
//        val authorToDetailDto = authorToDetailDto(author.detail)
//        return authorToDetailDto
//    }

    fun authorToDetailDto(
        author: Detail
    ): ProductDocument

    fun authorToDetailDto(
        author: ProductDetail
    ): Detail

//    fun authorsToAuthorDtos(
//        authors: List<Author>
//    ): List<AuthorDto>

}