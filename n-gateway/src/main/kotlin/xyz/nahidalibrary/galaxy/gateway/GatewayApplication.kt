package xyz.nahidalibrary.galaxy.gateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class GatewayApplication

fun main(args: Array<String>) {
  runApplication<GatewayApplication>(*args)
}