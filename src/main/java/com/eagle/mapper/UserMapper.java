package com.eagle.mapper;

import com.eagle.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 86182
* @description 针对表【tb_user】的数据库操作Mapper
* @createDate 2023-08-09 17:05:47
* @Entity com.eagle.pojo.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




