package xyz.nahidalibrary.galaxy.gateway.util

import net.minidev.json.JSONObject
import org.springframework.http.HttpStatus
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono
import java.nio.charset.StandardCharsets

object MonoUtils {
  
  fun buildReturnMono(json: JSONObject, exchange: ServerWebExchange): Mono<Void> {
    val response = exchange.response
    val bits = json.toJSONString().toByteArray(StandardCharsets.UTF_8)
    val buffer = response.bufferFactory().wrap(bits)
    response.setStatusCode(HttpStatus.UNAUTHORIZED)
    // 指定编码，否则在浏览器中会中文乱码
    response.headers.add("Content-Type", "text/plain;charset=UTF-8")
    return response.writeWith(Mono.just(buffer))
  }
}