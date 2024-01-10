package xyz.nahidalibrary.galaxy.core.vo

data class ListMusicVo(
  val musicList: List<MusicItemVo>
)

data class MusicItemVo(
  val id: Long,
  val name: String,
  val link: String
)
