package xyz.nahidalibrary.galaxy.gateway.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity

import org.springframework.security.web.server.SecurityWebFilterChain



@EnableWebFluxSecurity
@Configuration
class SecurityConfig {
  
  @Bean
  fun webFluxSecurityFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
    return http.authorizeExchange()
      .pathMatchers("/**").permitAll()
      .anyExchange().authenticated()
      .and()
      .csrf().disable()
      .build()
  }
}