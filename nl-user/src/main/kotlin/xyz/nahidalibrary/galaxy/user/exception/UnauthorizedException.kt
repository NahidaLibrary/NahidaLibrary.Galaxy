package xyz.nahidalibrary.galaxy.user.exception

import org.springframework.http.HttpStatus
import xyz.nahidalibrary.galaxy.user.common.BizErrorTypeEnum

class UnauthorizedException(
  override val errorType: BizErrorTypeEnum = BizErrorTypeEnum.UNAUTHORIZED,
  override val message: String = "认证失败",
  override val httpStatus: HttpStatus = HttpStatus.UNAUTHORIZED
) : BizException()