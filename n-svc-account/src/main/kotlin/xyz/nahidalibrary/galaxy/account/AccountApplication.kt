package xyz.nahidalibrary.galaxy.account

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class AccountApplication

fun main(args: Array<String>) {
  runApplication<xyz.nahidalibrary.galaxy.account.AccountApplication>(*args)
}