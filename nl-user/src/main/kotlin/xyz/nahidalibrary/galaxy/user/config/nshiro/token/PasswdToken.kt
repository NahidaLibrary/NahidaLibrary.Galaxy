package xyz.nahidalibrary.galaxy.user.config.nshiro.token

import org.apache.shiro.authc.AuthenticationToken
import xyz.nahidalibrary.galaxy.user.model.UserModel

class PasswdToken(
  private val account: UserModel,
  private val passwd: String,
) : AuthenticationToken {
  
  override fun getPrincipal(): UserModel = account
  
  override fun getCredentials(): String = passwd
}