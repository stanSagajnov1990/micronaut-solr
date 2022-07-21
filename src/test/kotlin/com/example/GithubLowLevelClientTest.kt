package com.example

import com.example.boundary.GithubRelease
import io.micronaut.core.type.Argument
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

@MicronautTest
internal class GithubLowLevelClientTest {

    @Inject private lateinit var githubLowLevelClient: GithubLowLevelClient

    @Test
    fun test_Github_client() {
        val fetchReleases = githubLowLevelClient.fetchReleases()

        println(fetchReleases.block())
    }
}
