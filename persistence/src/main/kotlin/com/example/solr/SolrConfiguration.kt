package com.example.domain

import io.micronaut.context.annotation.ConfigurationProperties
import io.micronaut.context.annotation.Requires

@ConfigurationProperties(SolrConfiguration.PREFIX)
@Requires(property = SolrConfiguration.PREFIX)
class SolrConfiguration {
    var url: String? = null
    var collection: String? = null

    companion object {
        const val PREFIX = "solr"
        const val GITHUB_API_URL = "http://localhost:8081"
    }
}
