package xyz.nahidalibrary.galaxy.core.service.impl

import com.baomidou.mybatisplus.core.toolkit.Wrappers
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import xyz.nahidalibrary.galaxy.core.mapper.AlbumMapper
import xyz.nahidalibrary.galaxy.core.mapper.MusicMapper
import xyz.nahidalibrary.galaxy.core.service.MusicService
import xyz.nahidalibrary.galaxy.core.vo.AlbumItemVo
import xyz.nahidalibrary.galaxy.core.vo.ListAlbumVo
import xyz.nahidalibrary.galaxy.core.vo.ListMusicVo
import xyz.nahidalibrary.galaxy.core.vo.MusicItemVo

@Service
class MusicServiceImpl : MusicService {
  
  private val logger = LoggerFactory.getLogger(MusicServiceImpl::class.java)
  
  @Autowired
  private lateinit var musicMapper: MusicMapper
  
  @Autowired
  private lateinit var albumMapper: AlbumMapper
  
  override fun listAlbum() =
    ListAlbumVo(albumMapper.selectList(Wrappers.emptyWrapper())
      .map { AlbumItemVo(id = it.id!!, name = it.name, coverLink = "http://101.201.116.226/nlib/album_cover${it.coverLink}") })
  
  override fun listMusic(albumId: Long) =
    ListMusicVo(musicMapper.listByAlbumId(albumId)
      .map { MusicItemVo(id = it.id!!, name = it.name, link = "http://101.201.116.226/nlib/music${it.link}") })
}