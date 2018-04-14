package com.pm.slxy.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 付荣刚123
 * @since 2018-04-14
 */
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    @TableField("departmentName")
    private String departmentName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
        ", id=" + id +
        ", departmentName=" + departmentName +
        "}";
    }
}
