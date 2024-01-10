package xyz.nahidalibrary.galaxy.account.common

data class BizErrorResult(
  val error: xyz.nahidalibrary.galaxy.account.common.BizErrorTypeEnum = xyz.nahidalibrary.galaxy.account.common.BizErrorTypeEnum.SERVER_ERROR,
  val message: String = "服务器错误"
)

enum class BizErrorTypeEnum {
  SERVER_ERROR,
  UNAUTHORIZED,
  UNREGISTERED,
  VERIFICATION
}