package com.example

import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Test

@MicronautTest
internal class GithubLowLevelClientTest {

    @Inject private lateinit var githubLowLevelClient: GithubLowLevelClient

    @Test
    fun test_Github_client() {
        val fetchReleases = githubLowLevelClient.fetchPrices()

        println(fetchReleases.block())
    }
}
