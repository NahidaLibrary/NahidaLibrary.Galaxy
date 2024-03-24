package xyz.nahidalibrary.galaxy.user.service

import xyz.nahidalibrary.galaxy.user.model.UserModel
import xyz.nahidalibrary.galaxy.user.vo.LoginVo

interface UserService {
  
  fun login(username: String, password: String, isEmail: Boolean = false): LoginVo
}