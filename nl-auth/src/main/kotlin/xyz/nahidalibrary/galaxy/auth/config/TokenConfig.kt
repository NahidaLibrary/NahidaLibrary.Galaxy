//package xyz.nahidalibrary.galaxy.auth.config
//
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.security.oauth2.provider.ClientDetailsService
//import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices
//import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices
//import org.springframework.security.oauth2.provider.token.*
//import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter
//import org.springframework.security.oauth2.provider.token.store.JwtTokenStore
//import javax.sql.DataSource
//
//
//@Configuration
//class TokenConfig {
//  /**
//   * 秘钥串
//   */
//  private val SIGNING_KEY = "uaa"
//
//
//  @Bean
//  fun tokenStore(): TokenStore {
//    return JwtTokenStore(accessTokenConverter())
//  }
//
//  @Bean
//  fun accessTokenConverter(): JwtAccessTokenConverter {
//    val converter = JwtAccessTokenConverter()
//    converter.setSigningKey(SIGNING_KEY)
//    return converter
//  }
//
//  /**
//   * 配置令牌管理
//   */
//  @Bean
//  fun tokenService(
//    clientDetailsService: ClientDetailsService?,
//    tokenStore: TokenStore?,
//    accessTokenConverter: JwtAccessTokenConverter
//  ): AuthorizationServerTokenServices {
//    val service = DefaultTokenServices()
//    service.setClientDetailsService(clientDetailsService)
//    service.setSupportRefreshToken(true)
//    service.setTokenStore(tokenStore)
//    val tokenEnhancerChain = TokenEnhancerChain()
//    tokenEnhancerChain.setTokenEnhancers(listOf<TokenEnhancer>(accessTokenConverter))
//    service.setTokenEnhancer(tokenEnhancerChain)
//    return service
//  }
//
//  /**
//   * 授权码存储方式
//   */
//  @Bean
//  fun authorizationCodeServices(dataSource: DataSource?): AuthorizationCodeServices {
//    return JdbcAuthorizationCodeServices(dataSource)
//  }
//}