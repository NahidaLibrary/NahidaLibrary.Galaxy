package xyz.nahidalibrary.galaxy.gateway.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.convert.converter.Converter
import org.springframework.security.authentication.AbstractAuthenticationToken
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverterAdapter
import org.springframework.security.web.server.SecurityWebFilterChain
import reactor.core.publisher.Mono


@Configuration
@EnableWebFluxSecurity
class ResourceServerConfig {
  
  @Autowired
  private lateinit var nlAuthorizationManager: NlAuthorizationManager
  
  @Autowired
  private lateinit var nlServerAccessDeniedHandler: NlServerAccessDeniedHandler
  
  @Autowired
  private lateinit var nlServerAuthenticationEntryPoint: NlServerAuthenticationEntryPoint
  
  @Bean
  fun securityWebFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
    http.oauth2ResourceServer().jwt().jwtAuthenticationConverter(jwtAuthenticationConverter())
    http.authorizeExchange()
      .pathMatchers(
        "api/auth/**"
      ).permitAll()
      .anyExchange().access(nlAuthorizationManager)
      .and()
      .exceptionHandling()
      .accessDeniedHandler(nlServerAccessDeniedHandler)
      .authenticationEntryPoint(nlServerAuthenticationEntryPoint)
      .and()
      .csrf().disable()
    return http.build()
  }
  
  fun jwtAuthenticationConverter(): Converter<Jwt, Mono<AbstractAuthenticationToken>> {
    val jwtGrantedAuthoritiesConverter = JwtGrantedAuthoritiesConverter()
    val jwtAuthenticationConverter = JwtAuthenticationConverter()
    jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter)
    return ReactiveJwtAuthenticationConverterAdapter(jwtAuthenticationConverter)
  }
}