package xyz.nahidalibrary.galaxy.auth.dto

data class LoginDto(
  val username: String,
  val password: String,
  val code: String? = null
)