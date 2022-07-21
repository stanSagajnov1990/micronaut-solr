package com.example.boundary

import io.micronaut.scheduling.annotation.Scheduled
import jakarta.inject.Singleton
import org.slf4j.LoggerFactory

@Singleton
class JobScheduler {

    companion object {
        private val LOG = LoggerFactory.getLogger(JobScheduler::class.java)
    }

        @Scheduled(cron = "*/2 * * * *")
    fun executeAIJob() {
        LOG.info("ai job is executed")
    }
}
