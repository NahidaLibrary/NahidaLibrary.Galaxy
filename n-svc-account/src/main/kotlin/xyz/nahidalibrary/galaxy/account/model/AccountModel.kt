package xyz.nahidalibrary.galaxy.account.model

import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableName
import xyz.nahidalibrary.galaxy.account.anno.NoArg

@NoArg
@TableName("n_account")
data class AccountModel(
  var username: String,
  @TableField("\"password\"")
  var password: String?,
  /**用于JWT加密的密钥 与password相同，如果未设置则取随机值*/
  var secret: String,
  var nickname: String,
  var email: String? = null
): BaseModel()
