package xyz.nahidalibrary.galaxy.auth.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import xyz.nahidalibrary.galaxy.auth.dto.LoginDto
import xyz.nahidalibrary.galaxy.auth.vo.LoginVo

@RestController
@RequestMapping
class AuthController {
  
  @PostMapping("/login")
  fun login(@RequestBody loginDto: LoginDto): ResponseEntity<LoginVo> {
    return ResponseEntity.ok(LoginVo(token = "xxx"))
  }
}