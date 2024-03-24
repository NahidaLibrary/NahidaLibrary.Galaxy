package xyz.nahidalibrary.galaxy.user.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.apache.ibatis.annotations.Mapper
import xyz.nahidalibrary.galaxy.user.model.UserModel

@Mapper
interface UserMapper : BaseMapper<UserModel> {
}