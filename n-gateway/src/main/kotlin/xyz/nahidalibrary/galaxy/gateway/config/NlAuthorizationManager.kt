package xyz.nahidalibrary.galaxy.gateway.config

import org.springframework.security.authorization.AuthorizationDecision
import org.springframework.security.authorization.ReactiveAuthorizationManager
import org.springframework.security.core.Authentication
import org.springframework.security.web.server.authorization.AuthorizationContext
import org.springframework.stereotype.Component
import org.springframework.util.StringUtils
import reactor.core.publisher.Mono

@Component
class NlAuthorizationManager : ReactiveAuthorizationManager<AuthorizationContext> {
  override fun check(authentication: Mono<Authentication>, context: AuthorizationContext): Mono<AuthorizationDecision> {
    val token = context.exchange.request.headers.getFirst("Authorization")
    if (StringUtils.hasText(token)) {
      return Mono.just(AuthorizationDecision(false))
    }
    return authentication.filter(Authentication::isAuthenticated)
      .map { AuthorizationDecision(true) }
      .defaultIfEmpty(AuthorizationDecision(false))
  }
}