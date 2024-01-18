package xyz.nahidalibrary.galaxy.core.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import xyz.nahidalibrary.galaxy.core.service.MusicService
import xyz.nahidalibrary.galaxy.core.vo.ListAlbumVo
import xyz.nahidalibrary.galaxy.core.vo.ListMusicVo

@RestController
@RequestMapping("/music")
class MusicController {
  
  @Autowired
  private lateinit var musicService: MusicService
  
  @GetMapping("/listAlbum")
  fun listAlbum(): ResponseEntity<ListAlbumVo> =
    ResponseEntity.ok(musicService.listAlbum())
  
  @GetMapping("/listMusic")
  fun listMusic(albumId: Long): ResponseEntity<ListMusicVo> =
    ResponseEntity.ok(musicService.listMusic(albumId))
}