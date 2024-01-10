package xyz.nahidalibrary.galaxy.account.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.apache.ibatis.annotations.Mapper
import xyz.nahidalibrary.galaxy.account.model.ThirdAccountModel

@Mapper
interface ThirdAccountMapper : BaseMapper<ThirdAccountModel> {
}