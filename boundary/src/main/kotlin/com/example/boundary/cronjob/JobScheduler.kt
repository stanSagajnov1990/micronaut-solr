package com.example.boundary.cronjob

import com.example.domain.ProductDetail
import com.example.domain.ProductDetailService
import io.micronaut.scheduling.annotation.Scheduled
import jakarta.inject.Inject
import jakarta.inject.Singleton
import org.slf4j.LoggerFactory

@Singleton
class JobScheduler {

    @Inject private lateinit var client: GithubLowLevelClient

    @Inject private lateinit var productDetailService: ProductDetailService

    @Scheduled(cron = "*/2 * * * *")
    fun executeAIJob() {
        LOG.info("start to execute AI job")

        var start = 0
        lateinit var productDetails: List<ProductDetail>
        do {
            productDetails = productDetailService.getProductDetails(start, 20);

            productDetails.forEach {
                var prices = client.fetchPrices(it.sku)
                val pricesDTO = prices.block()

                it.detail.averagePrice = pricesDTO.averagePrice
                it.detail.highestPrice = pricesDTO.highestPrice
                it.detail.medianPrice = pricesDTO.medianPrice
                it.detail.lowestPrice = pricesDTO.lowestPrice
                it.detail.occurrenceCount = pricesDTO.occurrenceCount

                productDetailService.saveProductDetail(it)
            }

            start = 20
        } while(productDetails.size == 20)

//        val productDetail = productDetailService.getProductDetail("sku-1")
//
//
//        val pricesDTO = prices.block()
//        productDetail.detail.averagePrice = pricesDTO.averagePrice
//        productDetail.detail.highestPrice = pricesDTO.highestPrice
//        productDetail.detail.medianPrice = pricesDTO.medianPrice
//        productDetail.detail.lowestPrice = pricesDTO.lowestPrice
//        productDetail.detail.occurrenceCount = pricesDTO.occurrenceCount
//
//        productDetailService.addProductDetail(productDetail)


//        LOG.info(prices.toString())
        LOG.info("ai job has been executed")
    }

    companion object {
        private val LOG = LoggerFactory.getLogger(JobScheduler::class.java)
    }
}
