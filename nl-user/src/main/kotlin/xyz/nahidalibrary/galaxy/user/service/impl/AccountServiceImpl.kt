package xyz.nahidalibrary.galaxy.user.service.impl

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import org.apache.shiro.SecurityUtils
import org.apache.shiro.authc.AuthenticationException
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import xyz.nahidalibrary.galaxy.user.common.BizErrorTypeEnum
import xyz.nahidalibrary.galaxy.user.config.nshiro.getId
import xyz.nahidalibrary.galaxy.user.config.nshiro.getSecret
import xyz.nahidalibrary.galaxy.user.config.nshiro.getUsername
import xyz.nahidalibrary.galaxy.user.config.nshiro.token.PasswdToken
import xyz.nahidalibrary.galaxy.user.exception.UnauthorizedException
import xyz.nahidalibrary.galaxy.user.mapper.AccountMapper
import xyz.nahidalibrary.galaxy.user.model.UserModel
import xyz.nahidalibrary.galaxy.user.service.AccountService
import xyz.nahidalibrary.galaxy.user.util.CommonUtils
import xyz.nahidalibrary.galaxy.user.util.JwtUtils
import xyz.nahidalibrary.galaxy.user.vo.LoginVo

@Service
class AccountServiceImpl : AccountService {
  
  private val logger = LoggerFactory.getLogger(AccountServiceImpl::class.java)
  
  @Autowired
  private lateinit var accountMapper: AccountMapper
  
  override fun login(username: String, password: String, isEmail: Boolean): LoginVo {
    val account = if (isEmail) {
      val wrapper = QueryWrapper<UserModel>().eq(UserModel::email.name, username)
      accountMapper.selectOne(wrapper)
        ?: throw UnauthorizedException(BizErrorTypeEnum.UNREGISTERED, "邮箱未绑定,或者账号未注册")
    } else {
      getOrCreate(username, password)
    }
    
    val subject = SecurityUtils.getSubject()
    try {
      subject.login(PasswdToken(account, password))
    } catch (e: AuthenticationException) {
      throw UnauthorizedException()
    }
    // perf: 异地登录
    return LoginVo(token = JwtUtils.sign(subject.getId(), subject.getUsername(), subject.getSecret()))
  }
  
  override fun getOrCreate(username: String, password: String): UserModel {
    val wrapper = QueryWrapper<UserModel>().eq(UserModel::username.name, username)
    val account = accountMapper.selectOne(wrapper)
    if (account != null) {
      return account
    }
    // 没有账号则创建账号
    val md5Pwd = CommonUtils.md5(password)
    val newAccount = UserModel(
      username = username,
      password = md5Pwd,
      secret = md5Pwd,
      nickname = username
    )
    accountMapper.insert(newAccount)
    return newAccount
  }
}