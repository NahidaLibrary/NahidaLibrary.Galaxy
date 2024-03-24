package xyz.nahidalibrary.galaxy.gateway.config

import net.minidev.json.JSONObject
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.server.ServerAuthenticationEntryPoint
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono
import xyz.nahidalibrary.galaxy.gateway.util.MonoUtils

@Component
class NlServerAuthenticationEntryPoint : ServerAuthenticationEntryPoint {
  override fun commence(exchange: ServerWebExchange, e: AuthenticationException): Mono<Void> {
    val json = JSONObject()
    json["errorType"] = "AUTH-UNAUTHORIZED"
    json["message"] = "未认证"
    return MonoUtils.buildReturnMono(json, exchange)
  }
}