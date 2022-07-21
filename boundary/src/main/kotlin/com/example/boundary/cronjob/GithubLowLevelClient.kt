package com.example.boundary.cronjob

import io.micronaut.http.HttpHeaders.ACCEPT
import io.micronaut.http.HttpHeaders.USER_AGENT
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.uri.UriBuilder
import jakarta.inject.Singleton
import reactor.core.publisher.Mono
import java.net.URI

@Singleton
class GithubLowLevelClient(
    configuration: AIServiceConfiguration,
    @param:Client(AIServiceConfiguration.AI_API_URL) private val httpClient: HttpClient
) {

    fun fetchPrices(sku: String): Mono<PricesDTO> {
        val uri: URI = UriBuilder.of("/ai/skus/$sku/prices").build()
        val req: HttpRequest<*> = HttpRequest.GET<String>(uri) // <4>
            .header(USER_AGENT, "Micronaut HTTP Client") // <5>
            .header(ACCEPT, "application/vnd.github.v3+json, application/json") // <6>
        return Mono.from(httpClient.retrieve(req, PricesDTO::class.java)) // <7>
    }
}
