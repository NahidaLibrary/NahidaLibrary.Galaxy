package xyz.nahidalibrary.galaxy.core.api

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient("auth-svc")
interface AuthApi {
  
  @GetMapping("/ping")
  fun ping(): String
}