package xyz.nahidalibrary.galaxy.core.service

import xyz.nahidalibrary.galaxy.core.vo.ListAlbumVo
import xyz.nahidalibrary.galaxy.core.vo.ListMusicVo

interface MusicService {
  
  fun listAlbum(): ListAlbumVo
  
  fun listMusic(albumId: Long): ListMusicVo
}