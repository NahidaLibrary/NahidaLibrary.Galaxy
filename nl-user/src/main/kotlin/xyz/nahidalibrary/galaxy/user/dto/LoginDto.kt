package xyz.nahidalibrary.galaxy.user.dto

import xyz.nahidalibrary.galaxy.user.anno.NoArg

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