package com.pm.slxy.mapper;

import com.pm.slxy.entity.Teacher;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 付荣刚123
 * @since 2018-04-16
 */
public interface TeacherMapper extends BaseMapper<Teacher> {
    /**
     * 查找所有部门
     *
     * @return
     */
    List<String> selectDepartment();
}
