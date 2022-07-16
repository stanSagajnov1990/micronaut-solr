package com.example.solr

import jakarta.inject.Singleton
import org.apache.solr.client.solrj.SolrClient
import org.apache.solr.client.solrj.impl.HttpSolrClient
import org.apache.solr.common.SolrInputDocument

@Singleton
class SolrService {

    private val client: SolrClient = HttpSolrClient.Builder("http://localhost:8983/solr/collection1").build()

    fun populate() {
        for (i in 0..999) {
            val doc = SolrInputDocument()
            doc.addField("cat", "book")
            doc.addField("id", "book-$i")
            doc.addField("name", "The Legend of the Hobbit part $i")
            client.add(doc)
            if (i % 100 == 0) client.commit() // periodically flush
        }
        client.commit()
    }

    fun add() {
        val doc = SolrInputDocument()

        client.add(doc)
        client.commit()
    }
}
