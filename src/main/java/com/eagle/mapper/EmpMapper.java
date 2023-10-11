package com.eagle.mapper;

import com.eagle.pojo.Emp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 86182
* @description 针对表【tb_emp】的数据库操作Mapper
* @createDate 2023-08-09 17:05:46
* @Entity com.eagle.pojo.Emp
*/
@Mapper
public interface EmpMapper extends BaseMapper<Emp> {

}




