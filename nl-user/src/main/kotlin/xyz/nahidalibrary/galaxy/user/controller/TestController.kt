package xyz.nahidalibrary.galaxy.user.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {
  @GetMapping("/ping")
  fun probe(): ResponseEntity<String> {
    return ResponseEntity("ping...user", HttpStatus.OK)
  }
}