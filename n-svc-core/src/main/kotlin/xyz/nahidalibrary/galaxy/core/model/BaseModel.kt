package xyz.nahidalibrary.galaxy.core.model

import com.baomidou.mybatisplus.annotation.FieldFill
import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableLogic
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