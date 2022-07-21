package com.example

import com.example.boundary.GithubRelease
import io.micronaut.core.type.Argument
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
 // <1>
class GithubLowLevelClient(@param:Client(GithubConfiguration.GITHUB_API_URL) private val httpClient: HttpClient,  // <2>
                           configuration: GithubConfiguration) {  // <3>
    private val uri: URI = UriBuilder.of("/ai/skus/cement-1/prices")
//        .path(configuration.organization)
//        .path(configuration.repo)
//        .path("releases")
        .build()

    fun fetchReleases(): Mono<GithubRelease> {
        val req: HttpRequest<*> = HttpRequest.GET<String>(uri) // <4>
            .header(USER_AGENT, "Micronaut HTTP Client") // <5>
            .header(ACCEPT, "application/vnd.github.v3+json, application/json") // <6>
        return Mono.from(httpClient.retrieve(req, GithubRelease::class.java)) // <7>
    }
}
