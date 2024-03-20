package xyz.nahidalibrary.galaxy.gateway.filter

import net.minidev.json.JSONObject
import org.slf4j.LoggerFactory
import org.springframework.cloud.gateway.filter.GatewayFilterChain
import org.springframework.cloud.gateway.filter.GlobalFilter
import org.springframework.core.Ordered
import org.springframework.http.HttpStatus
import org.springframework.security.oauth2.core.OAuth2AccessToken
import org.springframework.stereotype.Component
import org.springframework.util.AntPathMatcher
import org.springframework.util.StringUtils
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono
import java.nio.charset.StandardCharsets


@Component
class GatewayFilter : GlobalFilter, Ordered {
  
  private val logger = LoggerFactory.getLogger(GatewayFilter::class.java)
  
  override fun filter(exchange: ServerWebExchange, chain: GatewayFilterChain): Mono<Void> {
    val requestUrl = exchange.request.path.value()
    val pathMatcher = AntPathMatcher()
    // auth服务所有放行
    if (pathMatcher.match("/api/auth/**", requestUrl)) {
      return chain.filter(exchange)
    }
    // 检查token是否存在
    val token = getToken(exchange)
    if (!StringUtils.hasText(token)) {
      return noTokenMono(exchange)
    }
    // 判断是否是有效的token
    return try {
      val tokenRequest = exchange.request.mutate().header("nl-user-id", "lkzc19").build()
      val build = exchange.mutate().request(tokenRequest).build()
      chain.filter(build)
    } catch (e: Exception) {
      logger.info("无效的token: {}", token)
      invalidTokenMono(exchange)
    }
  }
  
  override fun getOrder() = 0
  
  /**
   * 获取token
   */
  private fun getToken(exchange: ServerWebExchange): String? {
    val tokenStr = exchange.request.headers.getFirst("Authorization")
    return tokenStr.takeIf { StringUtils.hasText(it) }?.removePrefix("Bearer")?.trim()
  }
  
  /**
   * 缺失token 结果返回
   */
  private fun noTokenMono(exchange: ServerWebExchange): Mono<Void> {
    val json = JSONObject()
    json["errorType"] = "AUTH-UNAUTHORIZED"
    json["message"] = "缺失[token]"
    return buildReturnMono(json, exchange)
  }
  
  /**
   * 无效token 结果返回
   */
  private fun invalidTokenMono(exchange: ServerWebExchange): Mono<Void> {
    val json = JSONObject()
    json["errorType"] = "AUTH-UNAUTHORIZED"
    json["message"] = "无效[token]"
    return buildReturnMono(json, exchange)
  }
  
  private fun buildReturnMono(json: JSONObject, exchange: ServerWebExchange): Mono<Void> {
    val response = exchange.response
    val bits = json.toJSONString().toByteArray(StandardCharsets.UTF_8)
    val buffer = response.bufferFactory().wrap(bits)
    response.setStatusCode(HttpStatus.UNAUTHORIZED)
    // 指定编码，否则在浏览器中会中文乱码
    response.headers.add("Content-Type", "text/plain;charset=UTF-8")
    return response.writeWith(Mono.just(buffer))
  }
}