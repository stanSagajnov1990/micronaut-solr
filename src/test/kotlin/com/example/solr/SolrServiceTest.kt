package com.example.solr

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class SolrServiceTest {

    @Test
    fun populate() {
        val solrService = SolrService()
        solrService.populate()
    }
}
