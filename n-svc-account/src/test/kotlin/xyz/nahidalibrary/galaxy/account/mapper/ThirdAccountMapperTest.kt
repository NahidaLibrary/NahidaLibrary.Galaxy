package xyz.nahidalibrary.galaxy.account.mapper

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import xyz.nahidalibrary.galaxy.account.model.ThirdAccountModel


@SpringBootTest
class ThirdAccountMapperTest {
  
  @Autowired
  private lateinit var thirdAccountMapper: ThirdAccountMapper
  
  @Test
  fun testSelect() {
    val list: List<ThirdAccountModel> = thirdAccountMapper.selectList(null)
    list.forEach(System.out::println)
  }
}