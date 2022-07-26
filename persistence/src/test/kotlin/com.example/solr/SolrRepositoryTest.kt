package com.example.solr

import com.example.solr.data.ProductDocument
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@MicronautTest
internal class SolrRepositoryTest {

    @Inject
    private var solrRepository: SolrRepository? = null

    @Test
    fun populate() {
        solrRepository?.populate()
    }

    @Test
    fun add() {
        val i = 1
        val productDocument = ProductDocument(
            "cement-$i",
            "cement-$i",
            "cement-$i", "cement-$i", i.toFloat(), "EUR", i.toFloat(), i.toFloat(), i.toFloat(), i.toFloat(), i
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
        val results = solrRepository.findOneBySku("sku-1")
        println(results)
    }

    @Test
    fun toSolrInputDocument() {
        val solrRepository = SolrRepository()
        val productDocument = ProductDocument(
            "cement",
            "cement",
                "Zement", "Zement", 5f, "EUR", 5f, 5f, 5f, 5f, 5
        )
        val solrInputDocument = productDocument.toSolrInputDocument()

        println(solrInputDocument)
    }
}
