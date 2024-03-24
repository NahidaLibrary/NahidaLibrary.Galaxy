package xyz.nahidalibrary.galaxy.auth.controller

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import xyz.nahidalibrary.galaxy.auth.util.JwtUtils
import xyz.nahidalibrary.galaxy.auth.vo.PayloadVo
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/token")
class TokenController {
  
  private val logger = LoggerFactory.getLogger(TokenController::class.java)
  
  @PostMapping("/verify")
  fun verifyToken(request: HttpServletRequest): ResponseEntity<PayloadVo> {
    // token
    val tokenStr = request.getHeader("Authorization").removePrefix("bearer ")
    return try {
      val claims = JwtUtils.verifyToken(tokenStr).claims
      val payloadVo = PayloadVo(ok = true, userId = claims["userId"]!!.asString())
      ResponseEntity(payloadVo, HttpStatus.OK)
    } catch (e: Exception) {
      logger.error("无效签名: $tokenStr")
      ResponseEntity(PayloadVo(ok = false), HttpStatus.OK)
    }
  }
}