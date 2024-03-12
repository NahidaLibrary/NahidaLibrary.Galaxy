package xyz.nahidalibrary.galaxy.core.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {
  
  @GetMapping("/ping")
  fun ping(): ResponseEntity<String> {
    return ResponseEntity("pong", HttpStatus.OK)
  }
  
  @GetMapping("/auth")
  fun auth(): ResponseEntity<String> {
    return ResponseEntity("pong", HttpStatus.OK)
  }
}