package xyz.nahidalibrary.galaxy.account.config.nshiro.token

import org.apache.shiro.authc.AuthenticationToken
import xyz.nahidalibrary.galaxy.account.model.AccountModel

class PasswdToken(
  private val account: AccountModel,
  private val passwd: String,
) : AuthenticationToken {
  
  override fun getPrincipal(): AccountModel = account
  
  override fun getCredentials(): String = passwd
}