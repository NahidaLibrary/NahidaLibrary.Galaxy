package xyz.nahidalibrary.galaxy.gateway.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate


@Configuration
class RedisConfig {
  @Bean
  fun connectionFactory(): LettuceConnectionFactory {
    return LettuceConnectionFactory()
  }
  
  @Bean
  fun redisTemplate(connectionFactory: RedisConnectionFactory): RedisTemplate<String, String> {
    val template = RedisTemplate<String, String>()
    template.setConnectionFactory(connectionFactory)
    return template
  }
}