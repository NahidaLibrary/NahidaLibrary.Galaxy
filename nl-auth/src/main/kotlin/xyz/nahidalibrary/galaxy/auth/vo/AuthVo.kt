package xyz.nahidalibrary.galaxy.auth.vo

data class LoginVo(
  val token: String
)

data class PayloadVo(
  val ok: Boolean,
  val userId: String? = null
)
