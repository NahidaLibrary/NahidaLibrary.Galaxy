package xyz.nahidalibrary.galaxy.user.config

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler
import org.apache.ibatis.reflection.MetaObject
import org.springframework.stereotype.Component
import xyz.nahidalibrary.galaxy.user.model.BaseModel
import java.time.OffsetDateTime

/**
 * 数据库 插入或更新 自动填充字段
 */
@Component
class BaseModelHandler : MetaObjectHandler {
  /**
   * 插入填充
   * - createdAt: now
   */
  override fun insertFill(metaObject: MetaObject) {
    // 起始版本 3.3.3(推荐)
    this.strictInsertFill(metaObject, BaseModel::createdAt.name, { OffsetDateTime.now() }, OffsetDateTime::class.java)
  }
  
  /**
   * 更新填充
   * - updatedAt: now
   */
  override fun updateFill(metaObject: MetaObject) {
    // 起始版本 3.3.3(推荐)
    this.strictUpdateFill(metaObject, BaseModel::updatedAt.name, { OffsetDateTime.now() }, OffsetDateTime::class.java)
  }
}