package xyz.nahidalibrary.galaxy.user.common

data class BizErrorResult(
  val error: xyz.nahidalibrary.galaxy.user.common.BizErrorTypeEnum = xyz.nahidalibrary.galaxy.user.common.BizErrorTypeEnum.SERVER_ERROR,
  val message: String = "服务器错误"
)

enum class BizErrorTypeEnum {
  SERVER_ERROR,
  UNAUTHORIZED,
  UNREGISTERED,
  VERIFICATION
}