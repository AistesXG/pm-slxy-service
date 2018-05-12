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
     * 根据所在部门查找教师编号
     *
     * @param szbm
     * @return
     */
    List<String> selectTeacherZzjsbhByDept(String szbm);

    /**
     * 根据所在部门查找教师编号
     *
     * @param jggh
     * @return
     */
    String selectTeacherXmByJggh(String jggh);

    /**
     * 查找所有的教工编号
     *
     * @return
     */
    List<String> selectJggh();
}
