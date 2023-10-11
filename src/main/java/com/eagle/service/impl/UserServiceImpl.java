package com.eagle.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eagle.pojo.User;
import com.eagle.service.UserService;
import com.eagle.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author 86182
* @description 针对表【tb_user】的数据库操作Service实现
* @createDate 2023-08-09 17:05:47
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




