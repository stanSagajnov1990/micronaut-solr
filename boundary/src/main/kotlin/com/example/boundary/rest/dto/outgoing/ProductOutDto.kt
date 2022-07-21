package com.example.boundary.rest.dto.outgoing

import io.micronaut.core.annotation.Introspected

@Introspected
data class ProductOutDto(val id: String, val sku: String, val detail: DetailOutDto)
