package xyz.nahidalibrary.galaxy.account.config;

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.servers.Server
import org.springdoc.core.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {
  
  @Bean
  fun customOpenAPI(): OpenAPI = OpenAPI()
    .info(customInfo())
    .servers(customServer())
  
  private fun customInfo(): Info = Info()
    .title("account")
    .description("account 账户相关")
    .version("v1.0.0")
  
  private fun customServer(): List<Server> = listOf(
    Server().url("/api/account-svc/")
  )
  
  @Bean
  fun customApi(): GroupedOpenApi = GroupedOpenApi.builder()
    .group("default")
    .packagesToScan("xyz.nahidalibrary.galaxy.account.controller")
    .build()
}
