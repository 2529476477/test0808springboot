package com.eagle.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName tb_dept
 */
@TableName(value ="tb_dept")
@Data
public class Dept implements Serializable {
    /**
     * 部门ID
     */
    @TableId(type = IdType.AUTO)
    private Integer deptno;

    /**
     * 部门名称
     */
    private String dname;

    /**
     * 部门地址
     */
    private String loc;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}