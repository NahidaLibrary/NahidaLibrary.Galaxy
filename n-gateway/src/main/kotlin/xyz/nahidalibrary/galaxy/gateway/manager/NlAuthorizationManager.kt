package xyz.nahidalibrary.galaxy.gateway.manager

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.http.HttpMethod
import org.springframework.security.authorization.AuthorizationDecision
import org.springframework.security.authorization.ReactiveAuthorizationManager
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken
import org.springframework.security.web.server.authorization.AuthorizationContext
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono


//@Component
//class NlAuthorizationManager : ReactiveAuthorizationManager<AuthorizationContext>  {
//
//  private val logger = LoggerFactory.getLogger(NlAuthorizationManager::class.java)
//
//  @Autowired
//  private lateinit var redisTemplate: StringRedisTemplate
//
//  override fun check(
//    authentication: Mono<Authentication>,
//    authorizationContext: AuthorizationContext
//  ): Mono<AuthorizationDecision> {
//    val request = authorizationContext.exchange.request
//    // option 请求，全部放行
//    if (request.method === HttpMethod.OPTIONS) {
//      return Mono.just(AuthorizationDecision(true))
//    }
//
//    val path = request.uri.getPath()
//    val authorities = redisTemplate.opsForSet().members(path)
//    logger.info("访问路径:[{}], 放行角色:[{}]", path, authorities?.joinToString(",") ?: "ALL")
//
//    if (authorities.isNullOrEmpty()) return Mono.just(AuthorizationDecision(true))
//
//    // 不在权限范围内的url，全部拒绝
//    return authentication
//      .filter { it.isAuthenticated }
//      .flatMapIterable<GrantedAuthority> { it.authorities }
//      .map<String> { it.authority }
//      .any { authority: String? ->
//        Objects.equals(
//          authority,
//          authorities
//        )
//      }
//      .map<AuthorizationDecision> { granted: Boolean? ->
//        AuthorizationDecision(
//          granted!!
//        )
//      }
//      .defaultIfEmpty(AuthorizationDecision(false))
//  }
//
//}