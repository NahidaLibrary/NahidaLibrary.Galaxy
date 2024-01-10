package xyz.nahidalibrary.galaxy.core.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import xyz.nahidalibrary.galaxy.core.model.MusicModel

@Mapper
interface MusicMapper : BaseMapper<MusicModel> {
  
  fun listByAlbumId(@Param("albumId") albumId: Long): List<MusicModel>
}