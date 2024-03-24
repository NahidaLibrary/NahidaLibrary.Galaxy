package xyz.nahidalibrary.galaxy.user.mapper

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import xyz.nahidalibrary.galaxy.user.model.ThirdAccountModel


@SpringBootTest
class ThirdUserMapperTest {
  
  @Autowired
  private lateinit var thirdAccountMapper: ThirdAccountMapper
  
  @Test
  fun testSelect() {
    val list: List<ThirdAccountModel> = thirdAccountMapper.selectList(null)
    list.forEach(System.out::println)
  }
}