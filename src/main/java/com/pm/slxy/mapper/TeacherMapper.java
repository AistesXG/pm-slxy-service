package com.pm.slxy.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.pm.slxy.entity.Teacher;

import java.util.List;
import java.util.Map;

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

    /**
     * 根据所在部门查找教师姓名
     *
     * @param szbm
     * @return
     */
    List<String> selectTeacherXmByDept(String szbm);
}
