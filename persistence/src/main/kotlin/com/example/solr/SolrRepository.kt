package com.example.solr

import com.example.domain.SolrConfiguration
import com.example.solr.data.ProductDocument
import jakarta.inject.Singleton
import org.apache.solr.client.solrj.SolrClient
import org.apache.solr.client.solrj.impl.Http2SolrClient
import org.apache.solr.common.SolrInputDocument
import org.apache.solr.common.params.MapSolrParams
import kotlin.reflect.full.memberProperties


@Singleton
class SolrRepository(val solrConfiguration: SolrConfiguration) {

    private val client: SolrClient = Http2SolrClient.Builder("${solrConfiguration.url}/solr/${solrConfiguration.collection}").build()

    fun populate() {
        for (i in 0..9) {
            val productDocument = ProductDocument(
                "sku-$i",
                "sku-$i",
                "cement-$i", "cement-$i", price = i.toFloat(), "EUR")
//            val doc = SolrInputDocument()
//            doc.addField("cat", "book")
//            doc.addField("id", "book-$i")
//            doc.addField("name", "The Legend of the Hobbit part $i")
//            val solrInputDocument2 = productDocument.toSolrInputDocument()
//            val solrInputDocument = SolrInputDocument()
//            solrInputDocument.addField("id", "sku-$i")
//            solrInputDocument2.fieldNames.forEach {
//                solrInputDocument.addField(it, solrInputDocument2.getFieldValue(it))
//            }
//            solrInputDocument2.childDocuments.forEach {
//                it.addField("id", "child-$i")
//                solrInputDocument.addChildDocument(it)
//            }
            client.addBean(productDocument)
//            client.add(solrInputDocument)
            if (i % 100 == 0) client.commit() // periodically flush
        }
        client.commit()
    }

    fun add(productDocument: ProductDocument) {
//        val doc = productDocument.toSolrInputDocument()
//        doc.addField("id", productDocument.sku)

        client.addBean(productDocument)
        client.commit()
    }

    fun findOneBySku(sku: String): ProductDocument? {
        val queryParamMap: MutableMap<String, String> = HashMap()
        queryParamMap["q"] = """sku:"$sku"~1"""
        queryParamMap["sort"] = "id asc"
        val queryParams = MapSolrParams(queryParamMap)

        val productDocuments = client.query(queryParams).getBeans(ProductDocument::class.java)

        if (productDocuments.size > 1) {
            throw RuntimeException("the requested query returns either too many or no documents");
        } else {
            return productDocuments.firstOrNull()
        }
    }

    fun findByRange(start: Int, rows: Int): List<ProductDocument> {
        val queryParamMap: MutableMap<String, String> = HashMap()
        queryParamMap["q"] = """*:*"""
        queryParamMap["start"] = start.toString()
        queryParamMap["rows"] = rows.toString()
        queryParamMap["sort"] = "id asc"
        val queryParams = MapSolrParams(queryParamMap)

        return client.query(queryParams).getBeans(ProductDocument::class.java)
    }

    fun deleteById(id: String) {
        client.deleteById(id)
        client.commit()
    }
}

fun Any?.toSolrInputDocument(): SolrInputDocument {
    val solrInputDocument = SolrInputDocument()
    if (this != null) {
        solrInputDocument.addField("type_string", this::class.simpleName)
        this::class.memberProperties.forEach {
            val call = it.getter.call(this)
            if (call!!::class == Int::class || call!!::class == String::class) {
                solrInputDocument.addField(it.name, it.getter.call(this))
            } else {
                val childDocument = it.getter.call(this).toSolrInputDocument()
                solrInputDocument.addChildDocument(childDocument)
            }
        }
    }

    return solrInputDocument
}
