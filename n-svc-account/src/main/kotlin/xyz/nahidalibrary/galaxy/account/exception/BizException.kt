package xyz.nahidalibrary.galaxy.account.exception

import org.springframework.http.HttpStatus
import xyz.nahidalibrary.galaxy.account.common.BizErrorTypeEnum

open class BizException(
  open val errorType: BizErrorTypeEnum = BizErrorTypeEnum.SERVER_ERROR,
  override val message: String = "服务器错误",
  open val httpStatus: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR
): RuntimeException()