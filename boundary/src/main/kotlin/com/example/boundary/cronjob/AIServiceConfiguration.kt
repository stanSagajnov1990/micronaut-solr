package com.example.boundary.cronjob

import io.micronaut.context.annotation.ConfigurationProperties
import io.micronaut.context.annotation.Requires

@ConfigurationProperties(AIServiceConfiguration.PREFIX)
@Requires(property = AIServiceConfiguration.PREFIX)
class AIServiceConfiguration {
    var url: String? = null

    companion object {
        const val PREFIX = "ai"
        const val AI_API_URL = "http://localhost:8081"
    }
}
