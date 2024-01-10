package xyz.nahidalibrary.galaxy.core.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.apache.ibatis.annotations.Mapper
import xyz.nahidalibrary.galaxy.core.model.AlbumModel

@Mapper
interface AlbumMapper : BaseMapper<AlbumModel> {
}