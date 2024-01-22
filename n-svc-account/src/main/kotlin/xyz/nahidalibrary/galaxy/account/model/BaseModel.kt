package xyz.nahidalibrary.galaxy.account.model

import com.baomidou.mybatisplus.annotation.*
import java.time.OffsetDateTime

abstract class BaseModel {
  @TableId(type = IdType.AUTO)
  var id: Long? = null
  @TableField(fill = FieldFill.INSERT)
  var createAt: OffsetDateTime? = null
  @TableField(fill = FieldFill.UPDATE)
  var updateAt: OffsetDateTime? = null
  @TableField(value = "is_deleted", fill = FieldFill.INSERT)
  @TableLogic
  var deleted: Int = 0
}