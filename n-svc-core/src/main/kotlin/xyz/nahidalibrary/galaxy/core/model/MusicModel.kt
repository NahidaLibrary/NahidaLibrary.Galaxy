package xyz.nahidalibrary.galaxy.core.model

import com.baomidou.mybatisplus.annotation.TableName
import xyz.nahidalibrary.galaxy.core.anno.NoArg

@NoArg
@TableName("n_music")
data class MusicModel(
  val name: String,
  val link: String,
  val trainer: String,
  val trainerLink: String
) : BaseModel()