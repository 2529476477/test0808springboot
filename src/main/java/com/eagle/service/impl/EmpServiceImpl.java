package com.eagle.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eagle.pojo.Emp;
import com.eagle.service.EmpService;
import com.eagle.mapper.EmpMapper;
import org.springframework.stereotype.Service;

/**
* @author 86182
* @description 针对表【tb_emp】的数据库操作Service实现
* @createDate 2023-08-09 17:05:47
*/
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp>
    implements EmpService{

}




