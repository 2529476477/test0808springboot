package com.eagle.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eagle.pojo.Dept;
import com.eagle.service.DeptService;
import com.eagle.mapper.DeptMapper;
import org.springframework.stereotype.Service;

/**
* @author 86182
* @description 针对表【tb_dept】的数据库操作Service实现
* @createDate 2023-08-09 17:05:46
*/
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept>
    implements DeptService{

}




