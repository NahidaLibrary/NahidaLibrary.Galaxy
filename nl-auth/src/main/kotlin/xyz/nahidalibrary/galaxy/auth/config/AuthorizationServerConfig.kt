//package xyz.nahidalibrary.galaxy.auth.config
//
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.http.HttpMethod
//import org.springframework.security.authentication.AuthenticationManager
//import org.springframework.security.authentication.AuthenticationProvider
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider
//import org.springframework.security.core.userdetails.User
//import org.springframework.security.core.userdetails.UserDetailsService
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
//import org.springframework.security.crypto.password.PasswordEncoder
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer
//import org.springframework.security.provisioning.InMemoryUserDetailsManager
//
//
//@Configuration
//@EnableAuthorizationServer
//class AuthorizationServerConfig : AuthorizationServerConfigurerAdapter() {
//  // accessToken有效期
//  private val accessTokenValiditySeconds = 60 * 60 * 24 * 7 // 7天
//
//  // 添加商户信息
//  @Throws(Exception::class)
//  override fun configure(clients: ClientDetailsServiceConfigurer) {
//    // withClient appid
//    clients.inMemory().withClient("client_1").secret(passwordEncoder().encode("123456"))
//      .authorizedGrantTypes("password", "client_credentials", "refresh_token").scopes("all")
//      .accessTokenValiditySeconds(accessTokenValiditySeconds)
//  }
//
//  // 设置token类型
//  override fun configure(endpoints: AuthorizationServerEndpointsConfigurer) {
//    endpoints
//      .authenticationManager(authenticationManager())
//      .allowedTokenEndpointRequestMethods(
//        HttpMethod.GET,
//        HttpMethod.POST
//      )
//  }
//
//  override fun configure(oauthServer: AuthorizationServerSecurityConfigurer) {
//    // 允许表单认证
//    oauthServer.allowFormAuthenticationForClients()
//    // 允许check_token访问
//    oauthServer.checkTokenAccess("permitAll()")
//  }
//
//  @Bean
//  fun authenticationManager(): AuthenticationManager {
//    return AuthenticationManager { authentication -> daoAuthenticationProvider().authenticate(authentication) }
//  }
//
//  @Bean
//  fun daoAuthenticationProvider(): AuthenticationProvider {
//    val daoAuthenticationProvider = DaoAuthenticationProvider()
//    daoAuthenticationProvider.setUserDetailsService(userDetailsService())
//    daoAuthenticationProvider.isHideUserNotFoundExceptions = false
//    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder())
//    return daoAuthenticationProvider
//  }
//
//  // 设置添加用户信息,正常应该从数据库中读取
//  @Bean
//  fun userDetailsService(): UserDetailsService {
//    val userDetailsService = InMemoryUserDetailsManager()
//    userDetailsService.createUser(
//      User.withUsername("user_1").password(passwordEncoder().encode("123456"))
//        .authorities("ROLE_USER").build()
//    )
//    userDetailsService.createUser(
//      User.withUsername("user_2").password(passwordEncoder().encode("1234567"))
//        .authorities("ROLE_USER").build()
//    )
//    return userDetailsService
//  }
//
//  @Bean
//  fun passwordEncoder(): PasswordEncoder {
//    // 加密方式
//    return BCryptPasswordEncoder()
//  }
//}