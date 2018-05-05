package com.pm.slxy.service;

import com.baomidou.mybatisplus.service.IService;
import com.pm.slxy.entity.Teacher;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 付荣刚123
 * @since 2018-03-26
 */
public interface TeacherService extends IService<Teacher> {
    /**
     * 查找所有教师信息
     *
     * @return
     */
    ModelAndView selectTeachers(ModelAndView modelAndView);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    String deleteTeacherByIds(String ids);


    /**
     * 添加教师
     *
     * @param teacher
     * @return
     */
    String addTeacher(Teacher teacher);


    /**
     * 修改教师信息
     *
     * @param teacher
     * @return
     */
    String updateTeacher(Teacher teacher);

    /**
     * 根据id来查找一个教师信息
     *
     * @param modelAndView
     * @param id
     * @return
     */
    ModelAndView selectTeacher(ModelAndView modelAndView, int id);

    /**
     * 检测教师的编号是否在数据库中已经存在
     *
     * @param jggh
     * @return
     */
    Map<String, Boolean> checkTeacherNum(String jggh);

    /**
     * 检测教师的编号是否在数据库中已经存在
     *
     * @param sfzh
     * @return
     */
    Map<String, Boolean> checkTeacherIdCard(String sfzh);

    /**
     * 查找所有部门
     *
     * @return
     */
    List<String> selectDepartment();

    /**
     * 根据id来查找一个教师的详情
     *
     * @param id
     * @return
     */
    ModelAndView selectTeacherById(ModelAndView modelAndView, int id);

    /**
     * 根据所在部门搜索教师信息
     *
     * @param szbm
     * @return
     */
    ModelAndView selectTeacherByDept(ModelAndView modelAndView, String szbm);

    /**
     * 根据租房状态来搜素教师信息
     *
     * @param modelAndView
     * @param zfzt
     * @return
     */
    ModelAndView selectTeacherByStatus(ModelAndView modelAndView, String zfzt);

}
