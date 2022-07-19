package com.example.solr

import com.example.solr.data.DetailData;
import com.example.solr.data.ProductDocument
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

internal class SolrRepositoryTest {

    private var solrRepository: SolrRepository? = null

    @BeforeEach
    fun setup() {
        solrRepository = SolrRepository()
    }

    @Test
    fun populate() {
        solrRepository?.populate()
    }

    @Test
    fun add() {
        val i = 1
        val productDocument = ProductDocument(
            "cement-$i",
            listOf("cement-$i"),
            listOf(
                DetailData("cement-$i", "cement-$i", "", i, i, "EUR", i, i, i, i)
            )
        )
        solrRepository?.add(productDocument)
//        solrService?.add()
    }

    @Test
    fun deleteById() {
        for (i in 0..999) {
            solrRepository?.deleteById("sku-$i")
        }
    }

    @Test
    fun findBySku() {
        val solrRepository = SolrRepository()
        val results = solrRepository.findBySku("sku-1")
        println(results)
    }

    @Test
    fun toSolrInputDocument() {
        val solrRepository = SolrRepository()
        val productDocument = ProductDocument(
            "cement",
            listOf("cement"),
            listOf(
                DetailData("Zement", "Zement", "", 5, 5, "EUR", 5, 5, 5, 5)
            )
        )
        val solrInputDocument = productDocument.toSolrInputDocument()

        println(solrInputDocument)
    }
}
