package xyz.nahidalibrary.galaxy.auth.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import xyz.nahidalibrary.galaxy.auth.dto.LoginDto
import xyz.nahidalibrary.galaxy.auth.vo.LoginVo

@RestController
@RequestMapping
class TestController {
  
  @GetMapping("/ping")
  fun ping(): ResponseEntity<String> {
    return ResponseEntity("pong...auth", HttpStatus.OK)
  }
}