package xyz.nahidalibrary.galaxy.core.model

import com.baomidou.mybatisplus.annotation.TableName
import xyz.nahidalibrary.galaxy.core.anno.NoArg

@NoArg
@TableName("n_music")
data class MusicModel(
  var name: String,
  var link: String,
  var trainer: String,
  var trainerLink: String
) : BaseModel()