package xyz.nahidalibrary.galaxy.user.model

import com.baomidou.mybatisplus.annotation.*
import java.time.LocalDateTime
import java.time.OffsetDateTime

abstract class BaseModel {
  @TableId(type = IdType.AUTO)
  var id: Long? = null
  @TableField(fill = FieldFill.INSERT)
  var createdAt: OffsetDateTime? = null
  @TableField(fill = FieldFill.UPDATE)
  var updatedAt: OffsetDateTime? = null
  @TableField(value = "deletedAt")
  @TableLogic
  var deleteAt: LocalDateTime? = null
}