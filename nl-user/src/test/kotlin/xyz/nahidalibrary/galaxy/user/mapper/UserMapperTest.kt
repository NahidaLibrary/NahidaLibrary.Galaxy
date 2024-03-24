package xyz.nahidalibrary.galaxy.user.mapper

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import xyz.nahidalibrary.galaxy.user.model.UserModel


@SpringBootTest
class UserMapperTest {
  
  @Autowired
  private lateinit var userMapper: UserMapper
  
  @Test
  fun testSelect() {
    val list: List<UserModel> = userMapper.selectList(null)
    list.forEach(System.out::println)
  }
}