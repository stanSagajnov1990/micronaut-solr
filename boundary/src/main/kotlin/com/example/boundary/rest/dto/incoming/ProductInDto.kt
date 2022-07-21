package com.example.boundary.rest.dto.incoming

import io.micronaut.core.annotation.Introspected

@Introspected
class ProductInDto (
    val sku: String,
    val detail: DetailInDto
)