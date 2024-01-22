package xyz.nahidalibrary.galaxy.core.model

import com.baomidou.mybatisplus.annotation.TableName
import xyz.nahidalibrary.galaxy.core.anno.NoArg

@NoArg
@TableName("n_album")
data class AlbumModel(
  var name: String,
  var coverLink: String
) : BaseModel()
