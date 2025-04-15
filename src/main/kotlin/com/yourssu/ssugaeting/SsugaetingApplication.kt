package com.yourssu.ssugaeting

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@EnableCaching
@ConfigurationPropertiesScan
@SpringBootApplication
class SsugaetingApplication

fun main(args: Array<String>) {
    runApplication<SsugaetingApplication>(*args)
}
