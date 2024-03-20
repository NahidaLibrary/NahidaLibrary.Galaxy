package xyz.nahidalibrary.galaxy.core.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import xyz.nahidalibrary.galaxy.core.api.AuthApi
import xyz.nahidalibrary.galaxy.core.service.MusicService
import javax.servlet.http.HttpServletRequest

@RestController
class TestController {
  
  @Autowired
  private lateinit var authApi: AuthApi
  
  @GetMapping("/ping")
  fun ping(): ResponseEntity<String> {
    return ResponseEntity("pong", HttpStatus.OK)
  }
  
  @GetMapping("/header")
  fun header(request: HttpServletRequest): ResponseEntity<Map<String, String>> {
    val headers = request.headerNames
    val headerMap = mutableMapOf<String, String>()
    while (headers.hasMoreElements()) {
      val headerName = headers.nextElement() as String
      if (!headerName.startsWith("nl")) {
        continue
      }
      val headerValue = request.getHeader(headerName)
      headerMap[headerName] = headerValue
    }
    return ResponseEntity(headerMap, HttpStatus.OK)
  }
  
  @GetMapping("/ping.auth")
  fun authPing(): ResponseEntity<String> {
    return ResponseEntity(authApi.ping(), HttpStatus.OK)
  }
}