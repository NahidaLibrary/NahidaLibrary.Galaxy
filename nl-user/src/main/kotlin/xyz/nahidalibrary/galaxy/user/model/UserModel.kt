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
  var nickname: String,
  var email: String? = null
): BaseModel()
