package xyz.nahidalibrary.galaxy.auth.util

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.interfaces.DecodedJWT
import java.util.*


object JwtUtils {
  /**
   * 生成Token
   */
  fun generateToken(payload: Map<String, String>): String {
    val builder = JWT.create()
    payload.forEach { (k, v) -> builder.withClaim(k, v) }
    val instance = Calendar.getInstance()
    instance.add(Calendar.SECOND, 7)
    builder.withExpiresAt(instance.time)
    return builder.sign(Algorithm.HMAC256("asd")).toString()
  }
  
  /**
   * 验证token
   */
  fun verifyToken(token: String): DecodedJWT {
    return JWT.require(Algorithm.HMAC256("asd")).build().verify(token)
  }
}