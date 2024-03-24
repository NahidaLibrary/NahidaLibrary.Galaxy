package xyz.nahidalibrary.galaxy.gateway.config

import net.minidev.json.JSONObject
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.web.server.authorization.ServerAccessDeniedHandler
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono
import xyz.nahidalibrary.galaxy.gateway.util.MonoUtils

@Component
class NlServerAccessDeniedHandler : ServerAccessDeniedHandler {
  override fun handle(exchange: ServerWebExchange, e: AccessDeniedException): Mono<Void> {
    val json = JSONObject()
    json["errorType"] = "AUTH-UNAUTHORIZED"
    json["message"] = "拒绝访问"
    return MonoUtils.buildReturnMono(json, exchange)
  }
}