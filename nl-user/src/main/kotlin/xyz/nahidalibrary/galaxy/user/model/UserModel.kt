package xyz.nahidalibrary.galaxy.user.model

import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableName
import xyz.nahidalibrary.galaxy.user.anno.NoArg

@NoArg
@TableName("nl_user")
data class UserModel(
  var username: String,
  @TableField("\"password\"")
  var password: String?,
  /**用于JWT加密的密钥 与password相同，如果未设置则取随机值*/
  var secret: String,
  var nickname: String,
  var email: String? = null
): BaseModel()
