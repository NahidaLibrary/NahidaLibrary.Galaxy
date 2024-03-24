package xyz.nahidalibrary.galaxy.user.service.impl

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import xyz.nahidalibrary.galaxy.user.mapper.UserMapper
import xyz.nahidalibrary.galaxy.user.service.UserService
import xyz.nahidalibrary.galaxy.user.vo.LoginVo

@Service
class UserServiceImpl : UserService {
  
  private val logger = LoggerFactory.getLogger(UserServiceImpl::class.java)
  
  @Autowired
  private lateinit var userMapper: UserMapper
  
  override fun login(username: String, password: String, isEmail: Boolean): LoginVo {
    TODO()
  }
}