package xyz.nahidalibrary.galaxy.account.service

import xyz.nahidalibrary.galaxy.account.model.AccountModel
import xyz.nahidalibrary.galaxy.account.vo.LoginVo

interface AccountService {
  
  fun login(username: String, password: String, isEmail: Boolean = false): LoginVo
  
  fun getOrCreate(username: String, password: String): AccountModel
}