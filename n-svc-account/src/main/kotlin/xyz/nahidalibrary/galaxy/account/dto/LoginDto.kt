package xyz.nahidalibrary.galaxy.account.dto

import xyz.nahidalibrary.galaxy.account.anno.NoArg

@NoArg
data class LoginDto(
  val username: String,
  val password: String
)

@NoArg
data class LoginByCodeDto(
  val email: String,
  val code: String
)