package com.eagle.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @TableName tb_emp
 */
@TableName(value ="tb_emp")
@Data
public class Emp implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer empno;

    /**
     * 
     */
    private String ename;

    /**
     * 
     */
    private String job;

    /**
     * 
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hiredate;

    /**
     * 
     */
    private String sal;

    /**
     * 
     */
    private String dname;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}