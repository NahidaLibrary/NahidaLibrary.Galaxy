package xyz.nahidalibrary.galaxy.account.model

import com.baomidou.mybatisplus.annotation.TableName
import xyz.nahidalibrary.galaxy.account.anno.NoArg

@NoArg
@TableName("n_third_account")
data class ThirdAccountModel(
  var accountId: String,
  var thirdId: String,
  var type: ThirdAccountType
): BaseModel()

enum class ThirdAccountType {
  GITHUB
}
